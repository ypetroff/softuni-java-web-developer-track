import java.util.Scanner;

public class VendingMachine_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();
        double sum = 0;

        while (!userInput.equals("Start")) {
            double currentCoin = Double.parseDouble(userInput);
             if (currentCoin != .1 && currentCoin != .2 && currentCoin != .5 && currentCoin != 1 && currentCoin != 2) {
                 System.out.printf("Cannot accept %.2f%n", currentCoin);

             }else {
                 sum+= currentCoin;
             }

            userInput = scanner.nextLine();

        }
        userInput = scanner.nextLine();

       loop: while (!userInput.equals("End")) {

            switch (userInput) {
                case "Nuts":
                    if (sum < 2) {
                        System.out.println("Sorry, not enough money");
                        break loop;
                    } else {
                        sum-=2;
                        System.out.printf("Purchased %s%n", userInput);
                    }
                    break;
                case "Water":
                    if (sum < .7) {
                        System.out.println("Sorry, not enough money");
                        break loop;
                    } else {
                        sum-=.7;
                        System.out.printf("Purchased %s%n", userInput);
                    }
                    break;
                case "Crisps":
                    if (sum < 1.5) {
                        System.out.println("Sorry, not enough money");
                        break loop;
                    } else {
                        sum-=1.5;
                        System.out.printf("Purchased %s%n", userInput);
                    }
                    break;
                case "Soda":
                    if (sum < .8) {
                        System.out.println("Sorry, not enough money");
                        break loop;
                    } else {
                        sum-=.8;
                        System.out.printf("Purchased %s%n", userInput);
                    }
                    break;
                case "Coke":
                    if (sum < 1) {
                        System.out.println("Sorry, not enough money");
                        break loop;
                    } else {
                        sum-=1;
                        System.out.printf("Purchased %s%n", userInput);
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }

            userInput = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sum);

    }
}
