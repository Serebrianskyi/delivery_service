package controller.command;

import controller.util.ServletUtility;
import model.entity.User;
import model.service.impl.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.nonNull;

public class RegisterUser implements Command {
    private UserService userService;
    private static Logger logger = Logger.getLogger(RegisterUser.class);
    private HttpSession httpSession;

    public RegisterUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        httpSession = request.getSession();
        ServletUtility servletUtility = new ServletUtility();
        String firstName = new String(request.getParameter("firstName")
                .getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String surName = new String(request.getParameter("surName")
                .getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String lastName = new String(request.getParameter("lastName")
                .getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String email = request.getParameter("email");
        String password = new String(request.getParameter("password")
                .getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        if (nonNull(password) && nonNull(email)&&nonNull(firstName)
                && nonNull(surName)&&nonNull(lastName)) {
            User user = new User();
            user.setName(servletUtility.checkField(firstName));
            user.setSurName(servletUtility.checkField(surName));
            user.setLastName(servletUtility.checkField(lastName));
            user.setEmail(servletUtility.checkField(email));
            user.setPassword(servletUtility.checkField(password));
            user.setRoleId(1);
            logger.info("Information for register reader: " + user);
            if (!userService.userIsRegistered(user)){
                userService.create(user);
            }
            httpSession.setAttribute("role", user.getRoleId());
            httpSession.setAttribute("name", user.getName());
            httpSession.setAttribute("email", user.getEmail());
            httpSession.setAttribute("userId",user.getId());
            httpSession.setAttribute("user", user);
        }
        return "redirect: home";
    }
}
