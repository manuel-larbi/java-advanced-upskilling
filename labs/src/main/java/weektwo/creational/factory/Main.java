package weektwo.creational.factory;

import weektwo.creational.factory.database.DatabaseConnection;
import weektwo.creational.factory.database.DatabaseFactory;
import weektwo.creational.factory.shape.ShapeFactory;
import weektwo.creational.factory.shape.concretecreator.CircleShape;
import weektwo.creational.factory.shape.concretecreator.SquareShape;

public class Main {
    public static void main(String[] args) {
        ShapeFactory circle = new CircleShape();
        circle.drawShape();

        ShapeFactory square = new SquareShape();
        square.drawShape();


        // Simple factory
        DatabaseFactory databaseFactory = new DatabaseFactory();

        DatabaseConnection mySQLConnection = databaseFactory.databaseConnection("mysql");
        mySQLConnection.connect();

        DatabaseConnection postgresqlConnection = databaseFactory.databaseConnection("postgresql");
        postgresqlConnection.connect();

    }
}
