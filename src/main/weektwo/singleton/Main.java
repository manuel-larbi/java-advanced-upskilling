package weektwo.singleton;

import java.lang.reflect.Constructor;

public class Main {

    public static void main(String[] args) throws Exception {

        Logger logger = Logger.getInstance();
        logger.log("Logging message...");

        // Exercise 2: Using ConfigurationManager
        ConfigManager configManager = ConfigManager.getInstance();
        String value = configManager.getConfigValue("key");
        System.out.println("Configuration value: " + value);
    }

}
