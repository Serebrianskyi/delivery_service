package controller;

import controller.command.*;
import controller.command.Exception;
import model.service.impl.*;
import org.apache.log4j.Logger;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(urlPatterns = "/servlet/*")
public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new ConcurrentHashMap<>();
    private static Logger logger = Logger.getLogger(Servlet.class);

    @Override
    public void init(ServletConfig config) {
        DeliveryTypeService deliveryTypeService = new DeliveryTypeService();
        DepartmentService departmentService = new DepartmentService();
        ExpenseService expenseService = new ExpenseService();
        RequestService requestService = new RequestService();
        RoleService roleService = new RoleService();
        ScheduleService scheduleService = new ScheduleService();
        TariffService tariffService = new TariffService();
        UserService userService = new UserService();
        WeightService weightService = new WeightService();

        config.getServletContext().setAttribute("loggedUsers", new HashSet<String>());
        config.getServletContext().setAttribute("expenses", expenseService.findAll());

        commands.put("loginUser", new LoginUser(userService));
        commands.put("login", new Login());
        commands.put("home", new MainPage());
        commands.put("logout", new Logout());
        commands.put("admin", new AdminPage());
        commands.put("user", new UserPage(departmentService,deliveryTypeService,
                weightService,requestService,tariffService));
        commands.put("registration", new Registration());
        commands.put("error", new Exception());
        commands.put("viewUsers", new ViewUsers());
        commands.put("registerUser", new RegisterUser(userService));
        commands.put("about", new About());
        commands.put("tariff", new TariffPage(departmentService,deliveryTypeService,tariffService));
        commands.put("delivery", new Delivery());
        commands.put("createSchedule", new CreateSchedule(scheduleService));
        commands.put("createTariff", new CreateTariff(tariffService));
        commands.put("createWeight", new CreateWeight(weightService));
        commands.put("createDepartment", new CreateDepartment(departmentService));
        commands.put("createDeliveryType", new CreateDeliveryType(deliveryTypeService));
        commands.put("createRequest", new CreateRequest(requestService,deliveryTypeService,
                departmentService,weightService,tariffService));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getCommand(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getCommand(req, resp);
    }

    private void getCommand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        if (path.contains("admin/"))
            path = path.replaceAll(".*/servlet/admin/", "");
        else
            path = path.replaceAll(".*/servlet/", "");

        Command command = commands.getOrDefault(path, (req, res) -> "redirect: home");
        String page = command.execute(request, response);
        if (page.contains("redirect:")) {
            String destination = page.replaceAll("redirect: ", "");
            logger.info("Redirect on chosen command: " + destination);
            response.sendRedirect(request.getContextPath() + "/servlet/" + destination);
        } else {
            request.getRequestDispatcher(page).forward(request, response);
            logger.info("Forward on page: " + page);
        }
    }
}
