package controller.command;

import model.entity.*;
import model.service.impl.*;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserPage implements Command {
    private DepartmentService departmentService;
    private DeliveryTypeService deliveryTypeService;
    private WeightService weightService;
    private RequestService requestService;
    private TariffService tariffService;
    private HttpSession httpSession;
    private static Logger logger = Logger.getLogger(CreateRequest.class);

    public UserPage(DepartmentService departmentService,
                    DeliveryTypeService deliveryTypeService,
                    WeightService weightService,
                    RequestService requestService,
                    TariffService tariffService) {
        this.departmentService = departmentService;
        this.deliveryTypeService = deliveryTypeService;
        this.weightService = weightService;
        this.requestService = requestService;
        this.tariffService = tariffService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        httpSession = request.getSession();

        List<String > departments = departmentService.findAll().stream()
                .map(Department::getTown)
                .collect(Collectors.toList());
        List<String > deliveryTypes = deliveryTypeService.findAll().stream()
                .map(DeliveryType::getName)
                .collect(Collectors.toList());
        List<Double> weights = weightService.findAll().stream()
                .map(Weight::getValue).collect(Collectors.toList());
        List<Request> userRequests = requestService.findRequestsByUserId(
                (Integer) httpSession.getAttribute("userId")
        );

        List<DeliveryType> userDeliveryTypes = new ArrayList<>();
        List<Department> userDepartmentsFrom = new ArrayList<>();
        List<Department> userDepartmentsTo = new ArrayList<>();
        List<Weight> userWeights = new ArrayList<>();
        List<Double> userPrices = new ArrayList<>();

        Tariff tariff;
        Weight weight;
        for (Request r: userRequests) {
            tariff = tariffService.findById(r.getTariffId());
            weight = weightService.findById(r.getWeightId());


            System.out.println(r.getWeightId());
            System.out.println(weight.getValue());
            System.out.println(weight.getCoefficient());
            System.out.println(weight.getId());

            userWeights.add(weightService.findById(r.getWeightId()));
            userDepartmentsFrom.add(departmentService.findById(tariff.getDepartmentFromId()));
            userDepartmentsTo.add(departmentService.findById(tariff.getDepartmentToId()));
            userDeliveryTypes.add(deliveryTypeService.findById(tariff.getDeliveryTypeId()));
            userPrices.add(tariff.getPrice()*weight.getCoefficient());
            System.out.println(tariff.getPrice() + "    " + weight.getCoefficient() );
        }

        request.setAttribute("departments", departments);
        request.setAttribute("deliveryTypes", deliveryTypes);
        request.setAttribute("weights", weights);
        request.setAttribute("userRequests", userRequests);
        request.setAttribute("userWeights", userWeights);
        request.setAttribute("userDepartmentsFrom", userDepartmentsFrom);
        request.setAttribute("userDepartmentsTo", userDepartmentsTo);
        request.setAttribute("userDeliveryTypes", userDeliveryTypes);
        request.setAttribute("userPrices", userPrices);

        return "/WEB-INF/view/user.jsp";
    }
}
