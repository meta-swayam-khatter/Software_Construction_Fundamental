package A9;

public class Circle implements Shape {
    public final Shape.ShapeType type;
    private final Point center;
    private final double radius;
    private final long timestamp;

    /**
     * This is a constructor function which creates a new Circle with the provided attributes when an instance of this class is created
     * @param center origin / center point of the circle
     * @param radius radius of the circle
     */
    public Circle(Point center, double radius) {
        this.type = Shape.ShapeType.CIRCLE;
        this.center = center;
        this.radius = radius;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Point getOrigin() {
        return center;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        return center.distanceFrom(point) <= radius;
    }

    /**
     * this function finds the timestamp at which the Circle was created
     * @return timestamp of the circle
     */
    public long getTimeStamp() {
        return timestamp;
    }

    @Override
    public Shape.ShapeType getShapeType() {
        return type;
    }
}
