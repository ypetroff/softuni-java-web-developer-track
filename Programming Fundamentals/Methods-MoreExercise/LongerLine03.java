import java.util.Scanner;

public class LongerLine03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int point1x1 = Integer.parseInt(scanner.nextLine());
        int point1y1 = Integer.parseInt(scanner.nextLine());
        int point2x1 = Integer.parseInt(scanner.nextLine());
        int point2y1 = Integer.parseInt(scanner.nextLine());
        int point3x1 = Integer.parseInt(scanner.nextLine());
        int point3y1 = Integer.parseInt(scanner.nextLine());
        int point4x1 = Integer.parseInt(scanner.nextLine());
        int point4y1 = Integer.parseInt(scanner.nextLine());

        double lineOne = calculateDistance(point1x1, point1y1, point2x1, point2y1);
        double lineTwo = calculateDistance(point3x1, point3y1, point4x1, point4y1);

        if (lineOne >= lineTwo) {
            printPoints(point1x1, point1y1, point2x1, point2y1);
        }else {
            printPoints(point3x1, point3y1, point4x1, point4y1);
        }
    }

    private static double calculateDistance(int x1, int y1, int x2, int y2) {
        double distance;
        distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return distance;
    }

    private static void printPoints(int x1, int y1, int x2, int y2) {
        double diagonalToZeroPointOne;
        double diagonalToZeroPointTwo;

        diagonalToZeroPointOne = Math.sqrt(Math.pow(x1, 2) +Math.pow(y1, 2));
        diagonalToZeroPointTwo = Math.sqrt(Math.pow(x2, 2) +Math.pow(y2, 2));

        if (diagonalToZeroPointOne <= diagonalToZeroPointTwo) {
            System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
        }else {
            System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
        }
    }
}
