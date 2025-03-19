package A9;

public interface Shape {
    enum ShapeType{CIRCLE, SQUARE, RECTANGLE, TRIANGLE, POLYGON}

    double getArea();
    double getPerimeter();
    Point getOrigin();
    boolean isPointEnclosed(Point p);
    Shape.ShapeType getShapeType();
}
