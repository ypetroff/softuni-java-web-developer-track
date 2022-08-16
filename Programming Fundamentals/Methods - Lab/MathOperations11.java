import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        int secondNumber = Integer.parseInt(scanner.nextLine());

        double result = getResult(firstNumber, operation, secondNumber);
        System.out.println(new DecimalFormat("0.##").format(result));
    }

    private static double getResult(int firstNumber, String operation, int secondNumber) {
        double result = 0;

        switch (operation) {
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = (double)firstNumber / secondNumber;
                break;
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
        }
        return result;
    }
}
