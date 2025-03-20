package A9;

public interface Shape {
    enum ShapeType{CIRCLE, SQUARE, RECTANGLE, TRIANGLE, POLYGON}

    /**
     * this function finds the area of the shape
     * @return area of the shape
     */
    double getArea();

    /**
     * this function finds the perimeter of the shape
     * @return perimeter of the shape
     */
    double getPerimeter();

    /**
     * this function finds the origin of the shape
     * @return origin point of the shape
     */
    Point getOrigin();

    /**
     * this function checks if the given point is enclosed in the shape or not
     * @param p point which we want to check if is enclosed or not
     * @return true if enclosed, false otherwise
     */
    boolean isPointEnclosed(Point p);

    /**
     * this function returns the shape tpe of the shape
     * @return shape type
     */
    Shape.ShapeType getShapeType();
}
