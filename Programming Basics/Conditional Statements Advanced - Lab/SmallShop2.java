import java.util.Scanner;

public class SmallShop2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double bill = 0;
        switch (city) {
            case "Sofia":
                switch (product) {
                    case "coffee":
                        bill = quantity * .5;
                        break;
                    case "water":
                        bill = quantity * .8;
                        break;
                    case "beer":
                        bill = quantity * 1.2;
                        break;
                    case "sweets":
                        bill = quantity * 1.45;
                        break;
                    case "peanuts":
                        bill = quantity * 1.6;
                        break;
                }
                break;
            case "Plovdiv":
                if (product.equals("coffee")) {
                    bill = quantity * .4;

                } else if (product.equals("water")) {
                    bill = quantity * .7;
                } else if (product.equals("beer")) {
                    bill = quantity * 1.15;

                } else if (product.equals("sweets")) {
                    bill = quantity * 1.3;
                } else if (product.equals("peanuts")) {
                    bill = quantity * 1.5;
                }
                break;
            case "Varna":
                if (product.equals("coffee")) {
                    bill = quantity * .45;
                } else if (product.equals("water")) {
                    bill = quantity * .7;
                } else if (product.equals("beer")) {
                    bill = quantity * 1.1;
                } else if (product.equals("sweets")) {
                    bill = quantity * 1.35;
                } else if (product.equals("peanuts")) {
                    bill = quantity * 1.55;
                }
                break;
        }
        System.out.println(bill);
    }
}
