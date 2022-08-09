import java.util.Scanner;

public class DayOfWeek01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        if (input >= 1 && input <= 7) {
            String[] daysOfTheWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            System.out.println(daysOfTheWeek[input - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
