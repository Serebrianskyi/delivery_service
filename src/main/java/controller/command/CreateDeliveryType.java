package controller.command;

import model.entity.DeliveryType;
import model.service.impl.DeliveryTypeService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.Objects.nonNull;

public class CreateDeliveryType implements Command {
    private DeliveryTypeService deliveryTypeService;
    private static Logger logger = Logger.getLogger(CreateDeliveryType.class);

    public CreateDeliveryType(DeliveryTypeService deliveryTypeService) {
        this.deliveryTypeService = deliveryTypeService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        if (nonNull(name) && nonNull(description)) {
            DeliveryType deliveryType = new DeliveryType();
            deliveryType.setName(name);
            deliveryType.setDescription(description);

            logger.info("Information for create delivery type: " + deliveryType);
            if (!deliveryTypeService.deliveryTypeIsCreated(deliveryType)) {
                deliveryTypeService.create(deliveryType);
            }
        }
        return "redirect: home";
    }
}
