package lab.shapes;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(4.0, 9.0);
        Shape circle = new Circle(16.0);

        printAreaAndPerimeter(rectangle);
        printAreaAndPerimeter(circle);

    }

    private static void printAreaAndPerimeter(Shape shape) {

        System.out.println(shape.calculatePerimeter());
        System.out.println(shape.calculateArea());
    }
}
