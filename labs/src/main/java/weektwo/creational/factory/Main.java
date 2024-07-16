package weektwo.creational.factory;

import weektwo.creational.factory.database.DatabaseConnection;
import weektwo.creational.factory.database.DatabaseFactory;
import weektwo.creational.factory.shape.Shape;
import weektwo.creational.factory.shape.ShapeFactory;

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.createShape("circle");
        circle.draw();

        Shape square = factory.createShape("square");
        square.draw();

        DatabaseFactory databaseFactory = new DatabaseFactory();

        DatabaseConnection mySQLConnection = databaseFactory.databaseConnection("mysql");
        mySQLConnection.connect();

        DatabaseConnection postgresqlConnection = databaseFactory.databaseConnection("postgresql");
        postgresqlConnection.connect();

    }
}
