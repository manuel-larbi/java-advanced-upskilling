package weektwo.creational.singleton;

class Logger {
    private static Logger instance = null;

    // Private constructor to prevent instantiation
    private Logger() throws Exception {
    }

    {
        if (instance != null) {
            throw new Exception("Object is already declared");
        }
    }

    // Static method to get the singleton instance
    public static Logger getInstance() throws Exception {
        if (instance == null) {
            synchronized (Logger.class){
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}