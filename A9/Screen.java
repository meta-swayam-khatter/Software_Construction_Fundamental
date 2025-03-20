package A9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Screen {
    /*
     * this is a List of Shapes which stores all the shapes present on the screen
     */
    private final List<Shape> shapes = new ArrayList<>();

    /**
     * this function adds a shape to the screen
     * @param shape shape which is to be added
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * this function deletes a shape from the screen
     * @param shape shape wwhich is to be deleted
     */
    public void deleteShape(Shape shape) {
        shapes.remove(shape);
    }

    /**
     * this function deletes all the shapes of a particular type
     * @param type the type of which all the shapes has to be deleted
     */
    public void deleteShapesByType(Shape.ShapeType type) {
        shapes.removeIf(shape -> shape.getShapeType().equals(type));
    }

    /**
     * this function sorts the shapes present in the screen based on the criteria given by the user
     * @param criteria criteria on the basis of which we have to sort the shapes
     * @return the sorted List of shapes
     */
    public List<Shape> getShapesSortedBy(String criteria) {
        try {
            switch(criteria) {
                case "area":
                    return shapes.stream().sorted(Comparator.comparingDouble(Shape::getArea)).collect(Collectors.toList());

                case "perimeter":
                    return shapes.stream().sorted(Comparator.comparingDouble(Shape::getPerimeter)).collect(Collectors.toList());

                case "timestamp":
                    return shapes.stream().sorted(Comparator.comparingLong(shape -> ((Circle)shape).getTimeStamp())).collect(Collectors.toList());

                case "originDistance":
                    return shapes.stream().sorted(Comparator.comparingDouble(shape -> shape.getOrigin().distanceFrom(new Point(0, 0)))).collect(Collectors.toList());

                default:
                    throw new IllegalArgumentException("Invalid criteria for sorting the shapes!!");
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * this function finds the shapes which enclose the given point
     * @param p point which is to be checked is enclosed or not
     * @return List of shapes which enloses the given point
     */
    public List<Shape> getShapesEnclosingPoint(Point point) {
        return shapes.stream().filter(shape -> shape.isPointEnclosed(point)).collect(Collectors.toList());
    }

    /**
     * Additional function finds the shapes which are on top of the given target shape
     * @param target shape for which we want to check if any shape is above it
     * @return List of shapes which are above the target shape
     */
    public List<Shape> getShapesOnTopOf(Shape target) {
        return shapes.stream().filter(shape -> ((Circle)shape).getTimeStamp() > ((Circle)target).getTimeStamp() && shape.isPointEnclosed(target.getOrigin())).collect(Collectors.toList());
    }
}
