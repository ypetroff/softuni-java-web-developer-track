import java.util.Scanner;

public class ConvertMetersToKm01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int meters = Integer.parseInt(scanner.nextLine());
        double km = (double)meters / 1000;
        System.out.printf("%.2f", km);
    }
}
