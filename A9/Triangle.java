package A9;

public class Triangle implements Shape {
    private final Point origin;
    private final Point p1;
    private final Point p2;
    private final long timestamp;

    public Triangle(Point origin, Point p1, Point p2) {
        this.origin = origin;
        this.p1 = p1;
        this.p2 = p2;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public double getArea() {
        try {
            double s = (p1.distanceFrom(p2) + p1.distanceFrom(origin) + p2.distanceFrom(origin))/2;
            return Math.sqrt(s*(s-p1.distanceFrom(p2))*(s-p1.distanceFrom(origin))*(s-p2.distanceFrom(origin)));
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public double getPerimeter() {
        try {
            return (p1.distanceFrom(p2) + p1.distanceFrom(origin) + p2.distanceFrom(origin));
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public boolean isPointEnclosed(Point p) {
        try {
            Triangle t = new Triangle(origin, p1, p2);
            Triangle t1 = new Triangle(origin, p1, p);
            Triangle t2 = new Triangle(p1, p2, p);
            Triangle t3 = new Triangle(p2, origin, p);

            if(t.getArea() == (t1.getArea() + t2.getArea() + t3.getArea())) return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    public long getTimeStamp() {
        return timestamp;
    }
}
