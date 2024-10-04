package weektwo.creational.factory.shape.concretecreator;

import weektwo.creational.factory.shape.Shape;
import weektwo.creational.factory.shape.ShapeFactory;
import weektwo.creational.factory.shape.concreteproduct.Square;

public class SquareShape extends ShapeFactory {

    /**
     * @return {@link Square}
     */
    @Override
    public Shape createShape() {
        return new Square();
    }
}
