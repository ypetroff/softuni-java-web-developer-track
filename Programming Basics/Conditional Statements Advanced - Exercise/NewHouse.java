import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double cost = 0;
        switch (type) {
            case "Roses":
            cost = quantity * 5;
            if (quantity > 80) {
                cost = cost - cost * .1;
            }
            break;
            case "Dahlias":
                cost = quantity * 3.8;
                if (quantity > 90) {
                    cost = cost - cost * .15;
                }
                break;
            case "Tulips":
                cost = quantity * 2.8;
                if (quantity > 80) {
                    cost = cost - cost * .15;
                }
                break;
            case "Narcissus":
                cost = quantity * 3;
                if (quantity < 120) {
                    cost = cost + cost * .15;
                }
                break;
            case "Gladiolus":
                cost = quantity * 2.5;
                if (quantity < 80) {
                    cost = cost + cost * .2;
                }
                break;
        }
        if (budget >= cost) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", quantity, type, budget - cost);
        }else {
            System.out.printf("Not enough money, you need %.2f leva more.", cost - budget);
        }
    }
}
