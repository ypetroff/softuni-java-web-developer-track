import java.util.Scanner;

public class ReverseArrayOfStrings04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        for (int i = 0; i < input.length / 2; i++) {
            String temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }

        for (String s : input) {
            System.out.printf("%s ", s);
        }
    }
}
