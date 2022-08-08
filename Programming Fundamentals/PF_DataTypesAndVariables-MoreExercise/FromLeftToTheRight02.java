import java.util.Scanner;

public class FromLeftToTheRight02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cycles; i++) {
            String coupleOFNumbers = scanner.nextLine();
            String[] numArrays = coupleOFNumbers.split(" ");
            long leftNumber = Long.parseLong(numArrays[0]);
            long rightNumber = Long.parseLong(numArrays[1]);
            int sum = 0;

            if (leftNumber >= rightNumber) {
                long numCheck = String.valueOf(leftNumber).length();
                for (int j = 0; j <= numCheck; j++) {
                    long currentDigit = leftNumber % 10;
                    sum += currentDigit;
                    leftNumber /= 10;
                }
            } else  {
                long numCheck = String.valueOf(rightNumber).length();
                for (int j = 0; j <= numCheck; j++) {
                    long currentDigit = rightNumber % 10;
                    sum += currentDigit;
                    rightNumber /= 10;
                }

            }

            System.out.println(Math.abs(sum));

        }
    }
}
