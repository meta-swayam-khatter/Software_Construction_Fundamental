package A9;

public class Circle implements Shape {
    private final Point center;
    private final double radius;
    private final long timestamp;

    public Circle(Point center, double radius) {
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
    public boolean isPointEnclosed(Point p) {
        return center.distanceFrom(p) <= radius;
    }

    public long getTimeStamp() {
        return timestamp;
    }
}
