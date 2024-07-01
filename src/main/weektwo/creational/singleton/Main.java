package weektwo.creational.singleton;

public class Main {

    public static void main(String[] args) throws Exception {

        Logger logger = Logger.getInstance();
        logger.log("Logging message...");


        ConfigManager configManager = ConfigManager.getInstance();
        String value = configManager.getConfigValue("test.value");
        System.out.println("Configuration value: " + value);
    }

}
