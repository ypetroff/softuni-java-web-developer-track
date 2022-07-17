import java.util.Scanner;

public class TimePlus15min {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();
        int hoursIntoMinutes = hours * 60;
        int totalMinutes = minutes + hoursIntoMinutes + 15;
        int backToHours = totalMinutes / 60;
        if (backToHours >=24) {
            backToHours = 0;
        }
        int backToMinutes = totalMinutes % 60;
        if (backToMinutes < 10) {
            System.out.printf("%d:0%d", backToHours, backToMinutes);
        }else {
            System.out.printf("%d:%d", backToHours, backToMinutes);
        }
    }
}
