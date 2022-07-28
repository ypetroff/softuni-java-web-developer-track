import java.util.Scanner;

public class Travelling_v2_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();
        while (!destination.equals("End")) {
            double budget = Double.parseDouble(scanner.nextLine());
            double savings = 0;
            while (savings < budget) {
                double currentSaving = Double.parseDouble(scanner.nextLine());
                savings += currentSaving;
            }
            System.out.printf("Going to %s!%n", destination);
            destination = scanner.nextLine();
        }
    }
}
