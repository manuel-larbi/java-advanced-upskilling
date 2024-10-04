package weektwo.creational.factory.shape;

public abstract class ShapeFactory {
    public void drawShape() {
        createShape().draw();
    }

    public abstract Shape createShape();
}