package A9;

public class Square implements Shape {
    private final Shape.ShapeType type;
    private final Point origin;
    private final double side;
    private final long timestamp;

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
    public boolean isPointEnclosed(Point p) {
        return p.getX() >= origin.getX() && p.getX() <= origin.getX() + side && p.getY() >= origin.getY() && p.getY() >= origin.getY() + side;
    }

    public long getTimeStamp() {
        return timestamp;
    }

    @Override
    public Shape.ShapeType getShapeType() {
        return type;
    }
}
