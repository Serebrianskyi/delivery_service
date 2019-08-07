package controller.command;

import model.entity.User;
import model.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ViewUsers implements Command {
    private UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> readerList = userService.findAll();
        request.getSession().setAttribute("readerList", readerList);
        return "/WEB-INF/view/viewUsers.jsp";
    }
}
