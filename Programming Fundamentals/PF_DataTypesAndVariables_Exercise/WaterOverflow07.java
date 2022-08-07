import java.util.Scanner;

public class WaterOverflow07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int timesPouringWatter = Integer.parseInt(scanner.nextLine());
        int maxCapacity = 255;
        int totalLitters = 0;
        for (int i = 0; i < timesPouringWatter; i++) {
            int littersPoured = Integer.parseInt(scanner.nextLine());

            if (littersPoured + totalLitters > maxCapacity) {
                System.out.println("Insufficient capacity!");
            } else {
                totalLitters+=littersPoured;
            }
        }
        System.out.println(totalLitters);
    }
}
