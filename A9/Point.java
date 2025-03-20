package A9;

public class Point {
    private final double xCoordinate;
    private final double yCoordinate;

    /**
     * this is the constructor function of the point which creates a new point when an instance of the point class is created
     * @param xCoordinate x condinate of the point
     * @param yCoordinate y coordinate of the point
     */
    public Point(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * this function finds the x coordinate of the point
     * @return x coordinate
     */
    public double getX() {return xCoordinate;}

    /**
     * thisfunction finds the y coordinate of the point
     * @return y coordinate
     */
    public double getY() {return yCoordinate;}

    /**
     * this function returns the distance between this point and the point given in attribute
     * @param otherCoordinate point from which we have to calculate the distance
     * @return distance between the two points
     */
    public double distanceFrom(Point otherCoordinate) {
        return Math.sqrt(Math.pow(this.xCoordinate - otherCoordinate.xCoordinate, 2) + Math.pow(this.yCoordinate - otherCoordinate.yCoordinate, 2));
    }
}
