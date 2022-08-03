import java.util.Scanner;

public class ReversedChars07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char symbol = scanner.nextLine().charAt(0);
            output.append(symbol);

            if (i < 2) {
                output.append(" ");
            }
        }
        String reversed = output.reverse().toString();

        System.out.println(reversed);
    }
}
