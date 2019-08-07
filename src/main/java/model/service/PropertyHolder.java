package model.service;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHolder {
    private String result;
    private InputStream inputStream;
    private static Logger logger = Logger.getLogger(PropertyHolder.class);

    public String getPropValues(String property) {
        try {
            try {
                Properties prop = new Properties();
                String propFileName = "sql_query.properties";
                inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

                if (inputStream != null) {
                    prop.load(inputStream);
                } else {
                    logger.error("property file: " + propFileName + " not found in the classpath");
                    throw new FileNotFoundException();
                }
                logger.debug("Target query: " + property);
                result = prop.getProperty(property);
            } catch (IOException e) {
                throw new IOException(e);
            } finally {
                assert inputStream != null;
                inputStream.close();
            }
        } catch (IOException e) {
            logger.error("Error loading properties file: " + e);
        }
        return result;
    }
}
