package PointInRectangle02;

public class Rectangle {
    private final Point pointA;
    private final Point pointC;

    public Rectangle(Point pointA, Point pointC) {
        this.pointA = pointA;
        this.pointC = pointC;
    }

    public boolean isInBound(Point p) {
        return pointA.isGreaterThan(p) && pointC.isLessThan(p);
    }
}
