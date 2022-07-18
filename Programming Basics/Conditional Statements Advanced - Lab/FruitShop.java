import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                // banana	apple	orange	grapefruit	kiwi	pineapple	grapes
                //  2.50	1.20	0.85	1.45	2.70	5.50	3.85
                if (fruit.equals("banana")) {
                    double bill = quantity * 2.5;
                    System.out.printf("%.2f", bill);
                } else if (fruit.equals("apple")) {
                    double bill = quantity * 1.2;
                    System.out.printf("%.2f", bill);
                } else if ("orange".equals(fruit)) {
                    double bill = quantity * .85;
                    System.out.printf("%.2f", bill);
                } else if ("grapefruit".equals(fruit)) {
                    double bill = quantity * 1.45;
                    System.out.printf("%.2f", bill);
                } else if ("kiwi".equals(fruit)) {
                    double bill = quantity * 2.7;
                    System.out.printf("%.2f", bill);
                } else if ("pineapple".equals(fruit)) {
                    double bill = quantity * 5.5;
                    System.out.printf("%.2f", bill);
                } else if ("grapes".equals(fruit)) {
                    double bill = quantity * 3.85;
                    System.out.printf("%.2f", bill);
                } else {
                    System.out.println("error");
               }
                break;
            case "Saturday":
            case "Sunday":
                //banana	apple	orange	grapefruit	kiwi	pineapple	grapes
                //2.70  	1.25	0.90	1.60	    3.00	5.60	    4.20

                if (fruit.equals("banana")) {
                    double bill = quantity * 2.7;
                    System.out.printf("%.2f", bill);
                } else if (fruit.equals("apple")) {
                    double bill = quantity * 1.25;
                    System.out.printf("%.2f", bill);
                } else if (fruit.equals("orange")) {
                    double bill = quantity * .9;
                    System.out.printf("%.2f", bill);
                } else if (fruit.equals("grapefruit")) {
                    double bill = quantity * 1.6;
                    System.out.printf("%.2f", bill);
                } else if (fruit.equals("kiwi")) {
                    double bill = quantity * 3;
                    System.out.printf("%.2f", bill);
                } else if (fruit.equals("pineapple")) {
                    double bill = quantity * 5.6;
                    System.out.printf("%.2f", bill);
                } else if (fruit.equals("grapes")) {
                    double bill = quantity * 4.2;
                    System.out.printf("%.2f", bill);
                } else {
                    System.out.println("error");
                }
                break;
            default:
                System.out.println("error");
        }

    }
}
