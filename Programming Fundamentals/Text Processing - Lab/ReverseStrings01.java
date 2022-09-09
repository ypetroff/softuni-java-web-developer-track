import java.util.Scanner;

public class ReverseStrings01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            char[] chars = input.toCharArray();
            System.out.printf("%s = %s%n", input,reverseInput(chars));
            input = scanner.nextLine();
        }
    }

    private static String reverseInput(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
