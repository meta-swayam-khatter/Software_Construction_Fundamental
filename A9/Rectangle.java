package A9;

public class Rectangle implements Shape {
    private final Shape.ShapeType type;
    private final Point origin;
    private final Double length;
    private final Double height;
    private final long timestamp;

    public Rectangle(Point origin, Double length, Double height) {
        this.type = Shape.ShapeType.RECTANGLE;
        this.origin = origin;
        this.length = length;
        this.height = height;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public double getArea() {
        return (length * height);
    }

    @Override
    public double getPerimeter() {
        return (2 * (length + height));
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point p) {
        return p.getX() >= origin.getX() && p.getX() <= origin.getX() + length && p.getY() >= origin.getY() && p.getY() >= origin.getY() + height;
    }

    public long getTimeStamp() {
        return timestamp;
    }

    @Override
    public Shape.ShapeType getShapeType() {
        return type;
    }
}
