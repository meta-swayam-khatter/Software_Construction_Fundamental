package A9;

import java.util.List;

public class Polygon implements Shape {
    private final Shape.ShapeType type;
    private final Point origin;
    private final List<Point> points;
    private final long timestamp;
    private final int numberOfPoints;

    /**
     * This is a constructor function which creates a new Polygon with the provided attributes when an instance of this class is created 
     * @param origin origin point of the polygon
     * @param points List of points which creates all the points of the polygon except origin
     */
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
            for(int pointIndex=0; pointIndex<points.size()-1; pointIndex++) {
                area += (points.get(pointIndex).getX() + points.get(pointIndex+1).getX())*(points.get(pointIndex).getY() - points.get(pointIndex+1).getY());
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
            for(int pointIndex=0; pointIndex<numberOfPoints-1; pointIndex++) {
                perimeter += points.get(pointIndex).distanceFrom(points.get(pointIndex+1));
            }
            perimeter += points.get(numberOfPoints-1).distanceFrom(origin);
            return perimeter;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        try {
            Polygon poly = new Polygon(origin, points);
            Triangle triangle = new Triangle(origin, point, points.get(0));
            double areaOfTriangles = triangle.getArea();
            for(int pointIndex=0; pointIndex<numberOfPoints-1; pointIndex++) {
                triangle = new Triangle(points.get(pointIndex), point, points.get(pointIndex+1));
                areaOfTriangles += triangle.getArea();
            }
            triangle = new Triangle(origin, point, points.get(numberOfPoints-1));
            areaOfTriangles += triangle.getArea();
            return (poly.getArea() == (int)(areaOfTriangles*100)/100.0);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    /**
     * this function finds the timestamp at which the Polygon was created
     * @return timestamp of the polygon
     */
    public long getTimeStamp() {
        return timestamp;
    }

    @Override
    public Shape.ShapeType getShapeType() {
        return type;
    }
}
