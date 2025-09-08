package utils;  // Declares that this class is part of the 'utils' package

import java.io.InputStream;
import java.util.Properties;

// Utility class to read configuration values from a 'config.properties' file
public class ConfigReader {

    // Properties object to hold key-value pairs loaded from the config file
    private static Properties prop = new Properties();

    // Static block that executes once when the class is loaded
    static {
        try (
            // Load the 'config.properties' file from the classpath as an InputStream
            InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")
        ) {
            // Load the properties into the 'prop' object
            prop.load(is);
        } catch (Exception e) {
            // Print stack trace if there is an issue loading the properties file
            e.printStackTrace();
        }
    }

    // Static method to retrieve a property value based on a given key
    public static String get(String key) {
        return prop.getProperty(key);  // Returns the value associated with the key, or null if not found
    }
}
