package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static Properties initializeProperties() {
        prop = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
