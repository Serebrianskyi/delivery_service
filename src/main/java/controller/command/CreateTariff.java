package controller.command;

import model.entity.Tariff;
import model.service.impl.TariffService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.Objects.nonNull;

public class CreateTariff implements Command {
    private TariffService tariffService;
    private static Logger logger = Logger.getLogger(CreateTariff.class);

    public CreateTariff(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int value = Integer.parseInt(request.getParameter("value"));
        long price = Long.parseLong(request.getParameter("price"));
        Integer departmentFromId = Integer.parseInt(request.getParameter("departmentFromId"));
        Integer departmentToId = Integer.parseInt(request.getParameter("departmentToId"));
        Integer deliveryTypeId = Integer.parseInt(request.getParameter("deliveryTypeId"));

        if (nonNull(value) && nonNull(price) && nonNull(departmentFromId)
                && nonNull(departmentToId)&& nonNull(deliveryTypeId)) {
            Tariff tariff = new Tariff();
            tariff.setValue(value);
            tariff.setPrice(price);
            tariff.setDepartmentFromId(departmentFromId);
            tariff.setDepartmentToId(departmentToId);
            tariff.setDeliveryTypeId(deliveryTypeId);


            logger.info("Information for create tariff: " + tariff);
            if (!tariffService.tariffIsCreated(tariff)) {
                tariffService.create(tariff);
            }
        }
        return "redirect: home";
    }
}
