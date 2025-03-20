package A9;

public class Square implements Shape {
    private final Shape.ShapeType type;
    private final Point origin;
    private final double side;
    private final long timestamp;

    /**
     * This is a constructor function which creates a new Square with the provided attributes when an instance of this class is created
     * @param origin origin point of the square
     * @param side length of the side of the square
     */
    public Square(Point origin, double side) {
        this.type = Shape.ShapeType.SQUARE;
        this.origin = origin;
        this.side = side;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        return point.getX() >= origin.getX() && point.getX() <= origin.getX() + side && point.getY() >= origin.getY() && point.getY() >= origin.getY() + side;
    }

    /**
     * this function finds the timestamp at which the Square was created
     * @return timestamp of the square
     */
    public long getTimeStamp() {
        return timestamp;
    }

    @Override
    public Shape.ShapeType getShapeType() {
        return type;
    }
}
