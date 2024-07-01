package weektwo.creational.factory.database.concrete;

import weektwo.creational.factory.database.DatabaseConnection;

public class PostgresqlConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to Postgresql......");
    }
}
