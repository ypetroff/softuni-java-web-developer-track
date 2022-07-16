import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();
        double area = 0;
        if (figure.equals("square")) {
            double side1 = Double.parseDouble(scanner.nextLine());
            area = side1 * side1;
            System.out.printf("%.3f", area);
        } else if (figure.equals("rectangle")) {
            double side1 = Double.parseDouble(scanner.nextLine());
            double side2 = Double.parseDouble(scanner.nextLine());
            area = side1 * side2;
            System.out.printf("%.3f", area);
        } else if (figure.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            area = Math.PI * radius * radius;
            System.out.printf("%.3f", area);
            } else if (figure.equals("triangle")) {
            double side1 = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());
            area = side1 * height / 2;
            System.out.printf("%.3f", area);
        }
    }
}
