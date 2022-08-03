import java.util.Scanner;

public class SpecialNumbers10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int end = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= end ; i++) {
            int currentNumber = i;
            int sum = 0;

            while (currentNumber > 0) {
                int num = currentNumber % 10;

                sum+=num;
                currentNumber/= 10;
            }
           if (sum == 5 || sum == 7 || sum == 11) {
               System.out.printf("%d -> True%n", i);
           } else {
               System.out.printf("%d -> False%n", i);
           }
        }
    }
}
