package weektwo.creational.factory.shape.concretecreator;

import weektwo.creational.factory.shape.Shape;
import weektwo.creational.factory.shape.ShapeFactory;
import weektwo.creational.factory.shape.concreteproduct.Circle;

public class CircleShape extends ShapeFactory {
    /**
     * @return {@link Circle}
     */
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
