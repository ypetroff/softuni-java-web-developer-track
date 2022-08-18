import java.util.Scanner;

public class Orders05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        printTotalPrice(product, quantity);


    }

    private static void printTotalPrice(String product, int quantity) {
        double sum = 0;
        switch (product) {
            case "coffee":
                sum = 1.5 * quantity;
                break;
            case "water":
                sum = 1.0 * quantity;
                break;
            case "coke":
                sum = 1.4 * quantity;
                break;
            case "snacks":
                sum = 2.0 * quantity;
                break;
        }
        System.out.printf("%.2f", sum);
    }
}
