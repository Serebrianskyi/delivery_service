package controller.command;

import model.entity.Request;
import model.service.impl.*;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

import static java.util.Objects.nonNull;

public class CreateRequest implements Command {
    private RequestService requestService;
    private DeliveryTypeService deliveryTypeService;
    private DepartmentService departmentService;
    private WeightService weightService;
    private TariffService tariffService;
    private HttpSession httpSession;

    private static Logger logger = Logger.getLogger(CreateRequest.class);

    public CreateRequest(RequestService requestService,
                         DeliveryTypeService deliveryTypeService,
                         DepartmentService departmentService,
                         WeightService weightService,
                         TariffService tariffService) {
        this.requestService = requestService;
        this.deliveryTypeService = deliveryTypeService;
        this.departmentService = departmentService;
        this.weightService = weightService;
        this.tariffService = tariffService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        httpSession = request.getSession();

        LocalDate date = LocalDate.parse(request.getParameter("date"));
        Integer deliveryTypeId = deliveryTypeService.findDeliveryTypeByName(
                request.getParameter("deliveryType")).getId();
        Integer departmentFromId = departmentService.findDepartmentByTown(
                request.getParameter("departmentFrom")).getId();
        Integer departmentToId = departmentService.findDepartmentByTown(
                request.getParameter("departmentTo")).getId();
        Integer weightId;
        if (request.getParameter("deliveryType").equals("Documents")) {
            weightId = 1;
        } else {
            weightId = weightService.findWeightByValue(
                    Double.parseDouble(request.getParameter("weight"))
            ).getId();
        }
        Integer tariffId = tariffService.findTariffByDepartmentFromAndDepartmentToAndDeliveryType(
                departmentFromId, departmentToId, deliveryTypeId
        ).getId();

        if (nonNull(date) && nonNull(tariffId) && nonNull(weightId)) {
            Request userRequest = new Request();
            userRequest.setUserId((Integer) httpSession.getAttribute("userId"));
            userRequest.setDate(date);
            userRequest.setWeightId(weightId);
            userRequest.setTariffId(tariffId);

            logger.info("Information for create request: " + userRequest);
            requestService.create(userRequest);
        }
        return "redirect: home";
    }
}
