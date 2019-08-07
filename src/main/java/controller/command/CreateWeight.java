package controller.command;

import model.entity.Weight;
import model.service.impl.WeightService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.Objects.nonNull;

public class CreateWeight implements Command {
    private WeightService weightService;
    private static Logger logger = Logger.getLogger(CreateWeight.class);

    public CreateWeight(WeightService weightService) {
        this.weightService = weightService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        double value = Double.parseDouble(request.getParameter("value"));
        double coefficient = Double.parseDouble(request.getParameter("coefficient"));

        if (nonNull(value) && nonNull(coefficient)) {
            Weight weight = new Weight();
            weight.setValue(value);
            weight.setCoefficient(coefficient);

            logger.info("Information for create weight: " + weight);
            if (!weightService.weightIsCreated(weight)) {
                weightService.create(weight);
            }
        }
        return "redirect: home";
    }
}
