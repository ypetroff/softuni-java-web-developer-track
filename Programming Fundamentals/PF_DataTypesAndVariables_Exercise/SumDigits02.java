import java.util.Scanner;

public class SumDigits02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int length = String.valueOf(input).length();

        for (int i = 0; i < length; i++) {
            int currentDigit = input % 10;
            sum += currentDigit;
            input /= 10;
        }
        System.out.println(sum);
    }
}
