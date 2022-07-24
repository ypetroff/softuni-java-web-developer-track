import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double excursionMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());
        boolean enoughMoney = true;
        int daysCount = 0;
        int days = 0;
        loop:
        while (availableMoney <= excursionMoney) {
            String operation = scanner.nextLine();
            double currentMoney = Double.parseDouble(scanner.nextLine());
            days++;
            switch (operation) {
                case "save":
                    availableMoney += currentMoney;
                    if (availableMoney >= excursionMoney) {
                        break loop;
                    }
                    daysCount = 0;

                    break;
                case "spend":
                    availableMoney -= currentMoney;
                    if (availableMoney < 0) {
                        availableMoney = 0;
                    }
                    daysCount++;
                    if (daysCount == 5) {
                        enoughMoney = false;
                        break loop;
                    }
                    break;
            }
        }
        if (!enoughMoney) {
            System.out.printf("You can't save the money.%n%d", days);
        } else {
            System.out.printf("You saved the money for %d days.", days);
        }
    }
}
