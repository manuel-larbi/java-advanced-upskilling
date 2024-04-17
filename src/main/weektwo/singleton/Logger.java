package weektwo.singleton;

// Singleton Logger class
class Logger {
    // Private static instance variable
    private static Logger instance = null;

    // Private constructor to prevent instantiation
    private Logger() throws Exception {
    }

    {
        if (instance != null) {
            throw new Exception("Object already has declared");
        }
    }

    // Static method to get the singleton instance
    public static synchronized Logger getInstance() throws Exception {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}