package lab.shapes;

public class Rectangle extends Shape {

    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * (getHeight() + getWidth());
    }

    @Override
    public Double calculateArea() {
        return getHeight() * getWidth();
    }
}
