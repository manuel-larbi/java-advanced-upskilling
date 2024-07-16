package weektwo.creational.factory.database;

import weektwo.creational.factory.database.concrete.MySQLConnection;
import weektwo.creational.factory.database.concrete.PostgresqlConnection;

public class DatabaseFactory {
    public DatabaseConnection databaseConnection(String type) {
        if (type.equalsIgnoreCase("mysql")) {
            return new MySQLConnection();
        } else if (type.equalsIgnoreCase("postgresql")) {
            return new PostgresqlConnection();
        } else {
            throw new IllegalArgumentException("Unsupported database type: " + type);
        }
    }
}
