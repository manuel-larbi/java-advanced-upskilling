package weektwo.creational.factory.shape;

import weektwo.creational.factory.shape.concrete.Circle;
import weektwo.creational.factory.shape.concrete.Square;

public class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        } else {
            throw new IllegalArgumentException("Unsupported shape type: " + shapeType);
        }
    }
}