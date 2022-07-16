import java.text.DecimalFormat;
import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time1 = scanner.nextInt();
        int time2 = scanner.nextInt();
        int time3 = scanner.nextInt();
        int sum = time1 + time2 + time3;
        int minutes = sum / 60;
        int seconds = sum % 60;
        if (seconds < 10) {
            System.out.printf("%d:0%d", minutes, seconds);
        }else {
            System.out.printf("%d:%d", minutes, seconds);
        }

    }
}
