package A9;

public class Triangle implements Shape {
    private final Shape.ShapeType type;
    private final Point origin;
    private final Point point1;
    private final Point point2;
    private final long timestamp;

    /**
     * This is a constructor function which creates a new Triangle with the provided attributes when an instance of this class is created
     * @param origin the origin point of the triangle
     * @param point1 one of the points of the triangle other then the origin
     * @param point2 another point of the triangle other then the origin
     */
    public Triangle(Point origin, Point point1, Point point2) {
        this.type = Shape.ShapeType.TRIANGLE;
        this.origin = origin;
        this.point1 = point1;
        this.point2 = point2;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public double getArea() {
        try {
            double s = (point1.distanceFrom(point2) + point1.distanceFrom(origin) + point2.distanceFrom(origin))/2;
            return Math.sqrt(s*(s-point1.distanceFrom(point2))*(s-point1.distanceFrom(origin))*(s-point2.distanceFrom(origin)));
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public double getPerimeter() {
        try {
            return (point1.distanceFrom(point2) + point1.distanceFrom(origin) + point2.distanceFrom(origin));
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        try {
            Triangle mainTriangle = new Triangle(origin, point1, point2);
            Triangle miniTriangle1 = new Triangle(origin, point1, point);
            Triangle miniTriangle2 = new Triangle(point1, point2, point);
            Triangle miniTriangle3 = new Triangle(point2, origin, point);

            if(mainTriangle.getArea() == (miniTriangle1.getArea() + miniTriangle2.getArea() + miniTriangle3.getArea())) return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    /**
     * this function finds the timestamp at which the Triangle was created
     * @return timestamp of the triangle
     */
    public long getTimeStamp() {
        return timestamp;
    }

    @Override
    public Shape.ShapeType getShapeType() {
        return type;
    }
}
