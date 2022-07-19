import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String movieType = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int colons = Integer.parseInt(scanner.nextLine());
        double profit = 0;
        switch (movieType) {
            case "Premiere":
                profit = rows * colons * 12;
                break;
            case "Normal":
                profit = rows * colons * 7.5;
                break;
            case "Discount":
                profit = rows * colons * 5;
                break;
        }
        System.out.printf("%.2f", profit);
    }
}
