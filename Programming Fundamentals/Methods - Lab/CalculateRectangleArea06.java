import java.util.Scanner;

public class CalculateRectangleArea06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

       int area = rectangleArea(width, height);

        System.out.println(area);
    }

    private static int rectangleArea(int width, int height) {

        return width * height;
    }
}
