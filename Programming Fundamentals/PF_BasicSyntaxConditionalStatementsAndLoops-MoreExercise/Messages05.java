import java.util.Scanner;

public class Messages05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        char[][] symbols = {
                {' '},
                {' '},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= input; i++) {
            int currentInput = Integer.parseInt(scanner.nextLine());
            String inputAsAString = Integer.toString(currentInput);
            int secondIndex = inputAsAString.length() - 1;
            double firstIndex = (double) currentInput % 10;
            String currentChar = String.valueOf(symbols[(int) firstIndex][secondIndex]);

            sb.append(currentChar);
        }
      //  String output = sb.toString();
        System.out.println(sb.toString());
    }
}
