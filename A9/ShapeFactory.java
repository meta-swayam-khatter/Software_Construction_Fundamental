package A9;

import java.util.List;

public class ShapeFactory {
    public static Shape creatShape(Shape.ShapeType type, Point origin, List<Double> parameters, List<Point> points) {
        switch(type) {
            case CIRCLE:
                return new Circle(origin, parameters.get(0));

            case SQUARE:
                return new Square(origin, parameters.get(0));

            case RECTANGLE:
                return new Rectangle(origin, parameters.get(0), parameters.get(1));

            case TRIANGLE:
                return new Triangle(origin, points.get(0), points.get(1));

            case POLYGON:
                return new Polygon(origin, points);

            default:
                throw new IllegalArgumentException("Invalid Shape type!!");
        }
    }
}
