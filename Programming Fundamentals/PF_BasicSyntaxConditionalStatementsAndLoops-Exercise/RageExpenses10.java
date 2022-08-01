import java.util.Scanner;

public class RageExpenses10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int counter = 0;
        double amount = 0;

        for (int i = 1; i <= lostGames; i++) {
            boolean trashedHeadset = false, trashedMouse = false;

            if (i % 2 == 0) {
                amount += headsetPrice;
                trashedHeadset = true;
            }
            if (i % 3 == 0) {
                amount += mousePrice;
                trashedMouse = true;
            }
            if (trashedHeadset && trashedMouse) {
                amount += keyboardPrice;
                counter++;
            }
            if (counter == 2) {
                amount += displayPrice;
                counter = 0;
            }
        }
        System.out.printf("Rage expenses: %.2f lv.%n", amount);
    }
}
