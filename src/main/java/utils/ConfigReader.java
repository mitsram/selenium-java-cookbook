package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            FileInputStream file = new FileInputStream("config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        // Check environment variable first, then fall back to properties file
        String envValue = System.getenv(key.toUpperCase().replace(".", "_"));
        if (envValue != null) {
            return envValue;
        }
        return properties.getProperty(key);
    }
}
