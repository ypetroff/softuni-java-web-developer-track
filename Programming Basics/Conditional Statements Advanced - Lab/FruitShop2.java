import java.util.Scanner;

public class FruitShop2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double bill = 0;
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                // banana	apple	orange	grapefruit	kiwi	pineapple	grapes
                //  2.50	1.20	0.85	1.45	2.70	5.50	3.85
                switch (fruit) {
                    case "banana":
                        bill = quantity * 2.5;

                        break;
                    case "apple":
                        bill = quantity * 1.2;

                        break;
                    case "orange":
                        bill = quantity * .85;

                        break;
                    case "grapefruit":
                        bill = quantity * 1.45;

                        break;
                    case "kiwi":
                        bill = quantity * 2.7;

                        break;
                    case "pineapple":
                        bill = quantity * 5.5;

                        break;
                    case "grapes":
                        bill = quantity * 3.85;

                        break;
                    default:
                        System.out.println("error");
                        break;
                }
                break;
            case "Saturday":
            case "Sunday":
                //banana	apple	orange	grapefruit	kiwi	pineapple	grapes
                //2.70  	1.25	0.90	1.60	    3.00	5.60	    4.20

                switch (fruit) {
                    case "banana":
                        bill = quantity * 2.7;

                        break;
                    case "apple":
                        bill = quantity * 1.25;

                        break;
                    case "orange":
                        bill = quantity * .9;

                        break;
                    case "grapefruit":
                        bill = quantity * 1.6;

                        break;
                    case "kiwi":
                        bill = quantity * 3;

                        break;
                    case "pineapple":
                        bill = quantity * 5.6;

                        break;
                    case "grapes":
                        bill = quantity * 4.2;

                        break;
                    default:
                        System.out.println("error");
                        break;
                }
                break;
            default:
                System.out.println("error");
                break;
        }
        if (bill > 0) {
            System.out.printf("%.2f", bill);
        }
    }
}
