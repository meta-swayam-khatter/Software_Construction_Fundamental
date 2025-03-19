package A9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();

        Shape circle = ShapeFactory.creatShape(Shape.ShapeType.CIRCLE, new Point(5,5), Arrays.asList(3.0), Arrays.asList());
        Shape square = ShapeFactory.creatShape(Shape.ShapeType.SQUARE, new Point(1,1), Arrays.asList(4.0), Arrays.asList());
        Shape rectangle = ShapeFactory.creatShape(Shape.ShapeType.RECTANGLE, new Point(5, 5), Arrays.asList(3.0, 2.0), Arrays.asList());
        Shape triangle = ShapeFactory.creatShape(Shape.ShapeType.TRIANGLE, new Point(5, 5), Arrays.asList(), Arrays.asList(new Point(10, 10), new Point(5, 10)));
        Shape polygon = ShapeFactory.creatShape(Shape.ShapeType.POLYGON, new Point(5, 5), Arrays.asList(), Arrays.asList(new Point(5, 10), new Point(10, 10), new Point(10, 5)));

        screen.addShape(polygon);

        System.out.println("Area: " + polygon.getArea());
        System.out.println("Perimeter: " + polygon.getPerimeter());
        System.out.println("Is point enclosed (7.5,7.5): " + polygon.isPointEnclosed(new Point(7.5, 7.5)));
        System.out.println("Origin: " + polygon.getOrigin().getX() + ", " + polygon.getOrigin().getY());
        System.out.println("Shapes enclosing (3,3): " + screen.getShapesEnclosingPoint(new Point(3, 3)));
    }
}
