import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] expressionData = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = expressionData.length - 1; i >= 0; i--) {
            stack.push(expressionData[i]);
        }

        while (stack.size() != 1) {
            int firstDigit = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondDigit = Integer.parseInt(stack.pop());

            int result = operator.equals("+")
                    ? firstDigit + secondDigit
                    : firstDigit - secondDigit;

            stack.push(String.valueOf(result));
        }

        System.out.println(stack.pop());
    }
}
