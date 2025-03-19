package A9;

import java.util.List;

public class Polygon implements Shape {
    private final Shape.ShapeType type;
    private final Point origin;
    private final List<Point> points;
    private final long timestamp;
    private final int numberOfPoints;

    public Polygon(Point origin, List<Point> points) {
        this.type = Shape.ShapeType.POLYGON;
        this.origin = origin;
        this.points = points;
        this.numberOfPoints = points.size();
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public double getArea() {
        try {
            double area = (origin.getX() + points.get(0).getX())*(origin.getY() - points.get(0).getY());
            for(int index=0; index<points.size()-1; index++) {
                area += (points.get(index).getX() + points.get(index+1).getX())*(points.get(index).getY() - points.get(index+1).getY());
            }
            area += (points.get(numberOfPoints-1).getX() + origin.getX())*(points.get(numberOfPoints-1).getY() - origin.getY());
            return Math.abs(area / 2.0);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public double getPerimeter() {
        try {
            double perimeter = origin.distanceFrom(points.get(0));
            for(int index=0; index<numberOfPoints-1; index++) {
                perimeter += points.get(index).distanceFrom(points.get(index+1));
            }
            perimeter += points.get(numberOfPoints-1).distanceFrom(origin);
            return perimeter;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public boolean isPointEnclosed(Point p) {
        try {
            Polygon poly = new Polygon(origin, points);
            Triangle t = new Triangle(origin, p, points.get(0));
            double areaOfTriangles = t.getArea();
            for(int index=0; index<numberOfPoints-1; index++) {
                t = new Triangle(points.get(index), p, points.get(index+1));
                areaOfTriangles += t.getArea();
            }
            t = new Triangle(origin, p, points.get(numberOfPoints-1));
            areaOfTriangles += t.getArea();
            return (poly.getArea() == (int)(areaOfTriangles*100)/100.0);
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

    @Override
    public Shape.ShapeType getShapeType() {
        return type;
    }
}
