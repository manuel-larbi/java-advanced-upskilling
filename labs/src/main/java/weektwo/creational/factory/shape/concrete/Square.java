package weektwo.creational.factory.shape.concrete;

import weektwo.creational.factory.shape.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Creating a square...");
    }
}
