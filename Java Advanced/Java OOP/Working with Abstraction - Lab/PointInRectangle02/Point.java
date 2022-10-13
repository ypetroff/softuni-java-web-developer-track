package PointInRectangle02;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isGreaterThan(Point point) {
        return x <= point.x && y <= point.y;
    }

    public boolean isLessThan(Point point) {
        return x >= point.x && y >= point.y;
    }
}
