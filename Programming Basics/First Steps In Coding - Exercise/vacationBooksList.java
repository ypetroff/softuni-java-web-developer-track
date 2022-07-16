import java.util.Scanner;

public class VacBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bookPages = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int daysToReadTheBook = Integer.parseInt(scanner.nextLine());
        int readingHoursPerDay = (bookPages / pagesPerHour) / daysToReadTheBook;
        System.out.println(readingHoursPerDay);
    }
}
