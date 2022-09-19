import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());

        if(decimalNumber == 0) {
            System.out.println(0);
        } else {
            ArrayDeque<Integer> remainderStack = new ArrayDeque<>();

            while (decimalNumber > 0) {
                int remainder = decimalNumber % 2;
                remainderStack.push(remainder);
                decimalNumber /= 2;
            }

            for (Integer digit : remainderStack) {
                System.out.print(digit);
            }
        }
    }
}
