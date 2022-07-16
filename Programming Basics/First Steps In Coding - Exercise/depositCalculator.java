import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double deposit = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double compound = Double.parseDouble(scanner.nextLine());
        double totalEarnings = deposit + months * ((deposit * (compound / 100)) / 12);
        System.out.println(totalEarnings);
    }
}
