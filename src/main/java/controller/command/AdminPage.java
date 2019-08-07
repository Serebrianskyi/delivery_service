package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (!request.getSession().getAttribute("role").equals(2))
            return "/WEB-INF/view/main.jsp";
        return "/WEB-INF/view/admin.jsp";
    }
}
