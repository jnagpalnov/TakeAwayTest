package commonutilities;

import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtils {
    public static String getCentralData( String propertyName){
        return getCentralData("src/test/resources/CentralData.properties",propertyName);
    }
    public static String getCentralData(String filePath, String propertyName) {
        Properties prop = new Properties();
        InputStream input = null;
        String value=null;
        try {
            input = new FileInputStream(filePath);
            prop.load(input);
            value= prop.getProperty(propertyName);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                     Assert.fail(e.getMessage());
                }
            }
        }
        return value;
    }
}
