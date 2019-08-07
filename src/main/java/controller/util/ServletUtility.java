package controller.util;

import org.apache.log4j.Logger;

public class ServletUtility {
    private static Logger logger = Logger.getLogger(ServletUtility.class);

    /**
     * Method check valid of fields
     *
     * @param param fields from registration form
     */
    public String checkField(String param) {
        return param.replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;");
    }
}
