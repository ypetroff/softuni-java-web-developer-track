import java.util.Scanner;

public class LowerOrUpper08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char character = scanner.nextLine().charAt(0);

        if ( character >= 65 && character <= 90) {
            System.out.println("upper-case");
        } else if (character >= 97 && character <= 122) {
            System.out.println("lower-case");
        }
    }
}
