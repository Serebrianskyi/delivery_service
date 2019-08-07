package controller.command;

import model.entity.User;
import model.service.impl.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUser implements Command {
    private UserService userService;
    private HttpSession httpSession;
    private static Logger logger = Logger.getLogger(LoginUser.class);

    public LoginUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        httpSession = request.getSession();

        if (isHasAccess()) {
            return "redirect: home";
        }
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.findUserByEmailAndPassword(email, password);

        if (user == null) {
            logger.error("Access denied, user role is a GUEST email: " + email + " password " + password);
            return "redirect: registration";
        }

        httpSession.setAttribute("role", user.getRoleId());
        httpSession.setAttribute("name", user.getName());
        httpSession.setAttribute("surname", user.getSurName());
        httpSession.setAttribute("email", user.getEmail());
        httpSession.setAttribute("userId",user.getId());
        httpSession.setAttribute("user", user);

        logger.info("User is login as: " + user.getEmail() +
                " with role " + (user.getRoleId() == 1 ? "user" : "admin"));
        return "redirect: home";
    }

    private boolean isHasAccess() {
        return httpSession.getAttribute("role") != null;
    }
}
