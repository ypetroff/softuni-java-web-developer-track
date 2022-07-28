import java.util.Scanner;

public class SumOfTwoNumbers04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int sum;
        int combination = 0;
        boolean flag = false;
        int i, j = 0;
        loop: for (i = firstNumber; i <= secondNumber; i++) {
            for (j = firstNumber; j <= secondNumber; j++) {
                sum = i + j;
                combination++;
                if (sum == magicNumber) {
                    flag = true;
                    break loop;
                }
            }
        }
        if (flag) {
            System.out.printf("Combination N:%d (%d + %d = %d)", combination, i, j, magicNumber);
        } else {
            System.out.printf("%d combinations - neither equals %d", combination, magicNumber);
        }
    }
}
