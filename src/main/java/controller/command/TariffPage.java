package controller.command;

import model.entity.DeliveryType;
import model.entity.Department;
import model.entity.Tariff;
import model.service.impl.DeliveryTypeService;
import model.service.impl.DepartmentService;
import model.service.impl.TariffService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TariffPage implements Command {
    private DepartmentService departmentService;
    private DeliveryTypeService deliveryTypeService;
    private TariffService tariffService;
    private static Logger logger = Logger.getLogger(CreateRequest.class);

    public TariffPage(DepartmentService departmentService,
                      DeliveryTypeService deliveryTypeService,
                      TariffService tariffService) {
        this.departmentService = departmentService;
        this.deliveryTypeService = deliveryTypeService;
        this.tariffService = tariffService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Tariff> documentTariffs = tariffService.findAll().stream()
                .filter(tariff -> tariff.getDeliveryTypeId()==deliveryTypeService
                        .findDeliveryTypeByName("Documents").getId())
                .collect(Collectors.toList());
        List<Tariff> cargoTariffs = tariffService.findAll().stream()
                .filter(tariff -> tariff.getDeliveryTypeId()==deliveryTypeService
                        .findDeliveryTypeByName("Cargo").getId())
                .collect(Collectors.toList());

        List<DeliveryType> documentTariffDeliveryTypes = new ArrayList<>();
        List<DeliveryType>cargoTariffDeliveryTypes = new ArrayList<>();
        List<Department> documentTariffDepartmentsFrom = new ArrayList<>();
        List<Department> cargoTariffDepartmentsFrom = new ArrayList<>();
        List<Department> documentTariffDepartmentsTo = new ArrayList<>();
        List<Department> cargoTariffDepartmentsTo = new ArrayList<>();

        for (Tariff t: documentTariffs) {
            documentTariffDeliveryTypes.add(deliveryTypeService.findById(t.getDeliveryTypeId()));
            documentTariffDepartmentsFrom.add(departmentService.findById(t.getDepartmentFromId()));
            documentTariffDepartmentsTo.add(departmentService.findById(t.getDepartmentToId()));
        }
        for (Tariff t: cargoTariffs) {
            cargoTariffDeliveryTypes.add(deliveryTypeService.findById(t.getDeliveryTypeId()));
            cargoTariffDepartmentsFrom.add(departmentService.findById(t.getDepartmentFromId()));
            cargoTariffDepartmentsTo.add(departmentService.findById(t.getDepartmentToId()));
        }

        request.setAttribute("documentTariffs", documentTariffs);
        request.setAttribute("cargoTariffs", cargoTariffs);
        request.setAttribute("documentTariffDeliveryTypes", documentTariffDeliveryTypes);
        request.setAttribute("cargoTariffDeliveryTypes", cargoTariffDeliveryTypes);
        request.setAttribute("documentTariffDepartmentsFrom", documentTariffDepartmentsFrom);
        request.setAttribute("cargoTariffDepartmentsFrom", cargoTariffDepartmentsFrom);
        request.setAttribute("documentTariffDepartmentsTo", documentTariffDepartmentsTo);
        request.setAttribute("cargoTariffDepartmentsTo", cargoTariffDepartmentsTo);

        return "/WEB-INF/view/tariff.jsp";
    }
}
