package controller.command;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPage implements Command {
    private static Logger logger = Logger.getLogger(MainPage.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/view/main.jsp";
    }
}
