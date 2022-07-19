import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int hoursStart = Integer.parseInt(scanner.nextLine());
        int minutesStart = Integer.parseInt(scanner.nextLine());
        int hoursArrival = Integer.parseInt(scanner.nextLine());
        int minutesArrival = Integer.parseInt(scanner.nextLine());
        int start = hoursStart * 60 + minutesStart;
        int arrival = hoursArrival * 60 + minutesArrival;
        int time, timeMinutes, timeHours;
        if (arrival <= start && arrival >= start - 30 && arrival + 30 >= start) {
            System.out.println("On time");
        } else if (arrival > start) {
            System.out.println("Late");
        } else {
            System.out.println("Early");
        }
        System.out.println();
        if (arrival < start && start - arrival < 60) {
            time = start - arrival;
            System.out.printf("%d minutes before the start", time);
        } else if (arrival < start && start - arrival >= 60) {
            time = start - arrival;
            timeHours = time / 60;
            timeMinutes = time % 60;
            System.out.printf("%d:%02d hours before the start", timeHours, timeMinutes);
        } else if (arrival > start && arrival - start < 60) {
            time = arrival - start;
            // Как се проверява %d или %02d при положение, че случая винаги ще дава числа по големи от 10?
            System.out.printf("%d minutes after the start", time);
            
        } else if (arrival > start && arrival - start >= 60){
            time = arrival - start;
            timeHours = time / 60;
            timeMinutes = time % 60;
            if (timeMinutes < 10) {
                System.out.printf("%d:%02d hours after the start", timeHours, timeMinutes);
            } else {
                System.out.printf("%d:%d hours after the start", timeHours, timeMinutes);
            }
        }
    }
}
