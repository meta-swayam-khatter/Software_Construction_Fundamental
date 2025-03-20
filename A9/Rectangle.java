package A9;

public class Rectangle implements Shape {
    private final Shape.ShapeType type;
    private final Point origin;
    private final Double length;
    private final Double height;
    private final long timestamp;

    /**
     * This is a constructor function which creates a new Rectangle with the provided attributes when an instance of this class is created
     * @param origin origin point of the rectangle
     * @param length length of the rectangle
     * @param height height of the rectangle
     */
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
    public boolean isPointEnclosed(Point point) {
        return point.getX() >= origin.getX() && point.getX() <= origin.getX() + length && point.getY() >= origin.getY() && point.getY() >= origin.getY() + height;
    }

    /**
     * this function finds the timestamp at which the Rectangle was created
     * @return timestamp of the rectangle
     */
    public long getTimeStamp() {
        return timestamp;
    }

    @Override
    public Shape.ShapeType getShapeType() {
        return type;
    }
}
