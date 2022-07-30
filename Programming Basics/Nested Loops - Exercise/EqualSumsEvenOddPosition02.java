import java.util.Scanner;

public class EqualSumsEvenOddPosition02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        while (number1 <= number2) {
            int currentNumber = number1++;
            String number = String.valueOf(currentNumber);
            int evenSum = 0;
            int oddSum = 0;
            for (int i = 0; i < number.length(); i++) {
                int digit = Character.digit(number.charAt(i), 10);
                if (i % 2 == 0) {
                    evenSum+=digit;
                } else {
                    oddSum+=digit;
                }
                }
                if (oddSum == evenSum) {
                    System.out.printf("%d ", currentNumber);
            }
        }


        }
    }
