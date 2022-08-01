import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double bill = 0;

        switch (type) {
            case "Students":
                switch (day) {
                    case "Friday":
                        bill = size * 8.45;
                        break;
                    case "Saturday":
                        bill = size * 9.8;
                        break;
                    case "Sunday":
                        bill = size * 10.46;
                        break;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        bill = size * 10.9;
                        break;
                    case "Saturday":
                        bill = size * 15.6;
                        break;
                    case "Sunday":
                        bill = size * 16;
                        break;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        bill = size * 15;
                        break;
                    case "Saturday":
                        bill = size * 20;
                        break;
                    case "Sunday":
                        bill = size * 22.5;
                        break;
                }
                break;
        }

        if (type.equals("Students") && size >= 30) {
            bill*=.85;
        }
        if (type.equals("Business") && size >= 100) {
            double tenPeople= bill / size * 10;
            bill-=tenPeople;
        }
        if (type.equals("Regular") && size >= 10 && size <= 20) {
            bill*=.95;
        }
        System.out.printf("Total price: %.2f", bill);
    }
}
