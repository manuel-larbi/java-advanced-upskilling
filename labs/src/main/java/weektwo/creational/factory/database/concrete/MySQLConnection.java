package weektwo.creational.factory.database.concrete;

import weektwo.creational.factory.database.DatabaseConnection;

public class MySQLConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL......");
    }
}
