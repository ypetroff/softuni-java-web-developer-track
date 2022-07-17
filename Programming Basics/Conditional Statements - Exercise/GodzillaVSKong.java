import java.util.Scanner;

public class GodzillaVSKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int extras = Integer.parseInt(scanner.nextLine());
        double costumeCost = Double.parseDouble(scanner.nextLine());
        double decor = budget * .1;
        double costumeExpense = extras * costumeCost;
        if (extras <= 150) {
            double totalExpenditures = decor + costumeExpense;
            if (budget >= totalExpenditures) {
                double money = budget - totalExpenditures;
                System.out.println("Action!");
                System.out.printf("Wingard starts filming with %.2f leva left.", money);
            } else {
                double money = totalExpenditures - budget;
                System.out.println("Not enough money!");
                System.out.printf("Wingard needs %.2f leva more.", money);
            }
        } else {
            double totalExpenditures = decor + (costumeExpense - .1 * costumeExpense);
            if (budget >= totalExpenditures) {
                double money = budget - totalExpenditures;
                System.out.println("Action!");
                System.out.printf("Wingard starts filming with %.2f leva left.", money);
            } else {
                double money = totalExpenditures - budget;
                System.out.println("Not enough money!");
                System.out.printf("Wingard needs %.2f leva more.", money);
            }
        }
    }
}
