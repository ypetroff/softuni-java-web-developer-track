import java.util.Scanner;

public class Backin30Minutes_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int timeAfter30Min = minutes + 30;

        if (timeAfter30Min >= 60) {
            timeAfter30Min-=60;
            hours++;
            if (hours == 24) {
                hours = 0;
            }
        }

        System.out.printf("%d:%02d", hours, timeAfter30Min);
    }
}
