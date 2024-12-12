package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getEnvVariable(String key) {
        // Check if the variable is already stored in properties
        String value = properties.getProperty(key);
        if (value == null) {
            // If not, check the environment variable
            value = System.getenv(key);
            if (value != null) {
                // Store it in properties for future use
                properties.setProperty(key, value);
                saveProperties();
            }
        }
        return value;
    }

    private static void saveProperties() {
        try (FileOutputStream output = new FileOutputStream(CONFIG_FILE)) {
            properties.store(output, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
