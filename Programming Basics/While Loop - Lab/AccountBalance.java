import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String deposit = scanner.nextLine();
        double sum = 0;
        while (!deposit.equals("NoMoreMoney")) {
            double currentNumber = Double.parseDouble(deposit);
            if (currentNumber <0) {
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n", currentNumber);
            sum+=currentNumber;
            deposit = scanner.nextLine();
        }
        System.out.printf("Total: %.2f%n", sum);
    }
}
