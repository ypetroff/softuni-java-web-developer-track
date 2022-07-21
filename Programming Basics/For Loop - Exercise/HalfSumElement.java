import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersCount = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 1; i <= numbersCount; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            if (currentNumber >= maxNumber) {
                maxNumber = currentNumber;
            }
            sum += currentNumber;
        }
        if (maxNumber == sum - maxNumber) {
            System.out.printf("Yes");
            System.out.println();
            System.out.printf("Sum = %d", maxNumber);
        } else {
            System.out.printf("No");
            System.out.println();
            if (maxNumber > sum - maxNumber) {
                System.out.printf("Diff = %d", maxNumber - (sum - maxNumber));
            } else {
                System.out.printf("Diff = %d", sum - maxNumber * 2);
            }
        }
    }
}
