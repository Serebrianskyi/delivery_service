package controller.command;

import model.entity.Department;
import model.service.impl.DepartmentService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.Objects.nonNull;

public class CreateDepartment implements Command {
    private DepartmentService departmentService;
    private static Logger logger = Logger.getLogger(CreateDepartment.class);

    public CreateDepartment(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String town = request.getParameter("town");
        String street = request.getParameter("street");
        String buildingNumber = request.getParameter("buildingNumber");
        Integer scheduleId = Integer.parseInt(request.getParameter("scheduleId"));


        if (nonNull(town) && nonNull(street) && nonNull(buildingNumber) && nonNull(scheduleId)) {
            Department department = new Department();
            department.setTown(town);
            department.setStreet(street);
            department.setBuildingNumber(buildingNumber);
            department.setSheduleId(scheduleId);

            logger.info("Information for create department: " + department);
            if (!departmentService.departmentIsCreated(department)) {
                departmentService.create(department);
            }
        }
        return "redirect: home";
    }
}
