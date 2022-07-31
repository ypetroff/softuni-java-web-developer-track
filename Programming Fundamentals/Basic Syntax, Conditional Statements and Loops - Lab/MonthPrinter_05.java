import java.util.Scanner;

public class MonthPrinter_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int month = Integer.parseInt(scanner.nextLine());
        String print = "";

        switch (month) {
            case 1:
                print = "January";
                break;
            case 2:
                print = "February";
                break;
            case 3:
                print = "March";
                break;
            case 4:
                print = "April";
                break;
            case 5:
                print = "May";
                break;
            case 6:
                print = "Jun";
                break;
            case 7:
                print = "July";
                break;
            case 8:
                print = "August";
                break;
            case 9:
                print = "September";
                break;
            case 10:
                print = "October";
                break;
            case 11:
                print = "November";
                break;
            case 12:
                print = "December";
                break;
            default:
                System.out.println("Error!");
        }
        System.out.println(print);
    }
}
