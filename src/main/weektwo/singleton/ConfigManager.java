package weektwo.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class ConfigManager {
    // Private static instance variable
    private static ConfigManager instance = null;

    // Private properties to hold configuration values
    private final Properties properties;


    // Private constructor to prevent instantiation
    private ConfigManager() throws Exception {
        if (instance != null) {
            throw new Exception("Object is already declared");
        }
        properties = new Properties();
        loadConfiguration();
    }

    // Static method to get the singleton instance
    public static synchronized ConfigManager getInstance() throws Exception {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    // Method to load configuration from file or environment variables
    private void loadConfiguration() {
        try {
            try (FileInputStream input = new FileInputStream("src/main/weektwo/singleton/config.properties")) {
                properties.load(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get a configuration value by key
    public String getConfigValue(String key) {
        return properties.getProperty(key);
    }
}

