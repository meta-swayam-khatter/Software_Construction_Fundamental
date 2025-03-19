package A9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Screen {
    private final List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void deleteShape(Shape shape) {
        shapes.remove(shape);
    }

    public void deleteShapesByType(Shape.ShapeType type) {
        shapes.removeIf(shape -> shape.getShapeType().equals(type));
    }

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

    public List<Shape> getShapesEnclosingPoint(Point p) {
        return shapes.stream().filter(shape -> shape.isPointEnclosed(p)).collect(Collectors.toList());
    }

    public List<Shape> getShapesOnTopOf(Shape target) {
        return shapes.stream().filter(shape -> ((Circle)shape).getTimeStamp() > ((Circle)target).getTimeStamp() && shape.isPointEnclosed(target.getOrigin())).collect(Collectors.toList());
    }
}
