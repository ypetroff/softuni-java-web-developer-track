import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        String currentBook = scanner.nextLine();
        boolean missingBook = true;
        int bookNumber = 0;
        while (!currentBook.equals("No More Books")) {
            if (currentBook.equals(bookName)) {
                missingBook = false;
                System.out.printf("You checked %d books and found it.%n", bookNumber);
                break;
            }
            bookNumber++;
            currentBook = scanner.nextLine();
        }
        if (missingBook) {
            System.out.printf("The book you search is not here!%nYou checked %d books.", bookNumber);
        }
    }
}
