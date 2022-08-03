import java.util.Scanner;

public class CharsToString06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String output = "";

        for (int i = 1; i <= 3; i++) {
            char symbol = scanner.nextLine().charAt(0);
            output = output + symbol;
        }

        System.out.println(output);
    }
}
