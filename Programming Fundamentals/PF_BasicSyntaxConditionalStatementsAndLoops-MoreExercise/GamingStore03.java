import java.util.Scanner;

public class GamingStore03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());
        String game = scanner.nextLine();

        double spentMoney = 0;
        boolean outOfMoney = false;

        while (!game.equals("Game Time")) {
            switch (game) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    if (balance < 39.99) {
                        System.out.println("Too Expensive");
                        break;
                    }
                    balance -= 39.99;
                    spentMoney += 39.99;
                    System.out.println("Bought " + game);
                    break;
                case "CS: OG":
                    if (balance < 15.99) {
                        System.out.println("Too Expensive");
                        break;
                    }
                    balance -= 15.99;
                    spentMoney += 15.99;
                    System.out.println("Bought " + game);
                    break;
                case "Zplinter Zell":
                    if (balance < 19.99) {
                        System.out.println("Too Expensive");
                        break;
                    }
                    balance -= 19.99;
                    spentMoney += 19.99;
                    System.out.println("Bought " + game);
                    break;
                case "Honored 2":
                    if (balance < 59.99) {
                        System.out.println("Too Expensive");
                        break;
                    }
                    balance -= 59.99;
                    spentMoney += 59.99;
                    System.out.println("Bought " + game);
                    break;
                case "RoverWatch":
                    if (balance < 29.99) {
                        System.out.println("Too Expensive");
                        break;
                    }
                    balance -= 29.99;
                    spentMoney += 29.99;
                    System.out.println("Bought " + game);
                    break;

                default:
                    System.out.println("Not Found");
            }
            if (balance == 0) {
                System.out.println("Out of money!");
                outOfMoney = true;
                break;
            }
            game = scanner.nextLine();
        }

        if (!outOfMoney) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spentMoney, balance);
        }

    }
}

