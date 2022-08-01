import java.util.Scanner;

public class StrongNumber06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int sum = 0, factorial = 1;
        int number = input;
        while (number != 0) {
            double currentDigit = (double)number % 10;
            for (int i = 2; i <= currentDigit; i++) { // i can have a value of 1 or 2, if the value is 2 the programme is faster
                factorial *= i;
            }
            sum+=factorial;
            factorial = 1;
            number/=10;
        }
        if (sum == input) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
