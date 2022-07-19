import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number1 = Integer.parseInt(scanner.nextLine());
        double number2 = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        double result = 0;
        String evenOrOdd;
        switch (operation) {
            case "+":
                result = number1 + number2;
                if (result % 2 == 0) {
                    evenOrOdd = "even";
                } else {
                    evenOrOdd = "odd";
                }
                System.out.printf("%.0f %s %.0f = %.0f - %s", number1, operation, number2, result, evenOrOdd);
                break;
            case "-":
                result = number1 - number2;
                if (result % 2 == 0) {
                    evenOrOdd = "even";
                } else {
                    evenOrOdd = "odd";
                }
                System.out.printf("%.0f %s %.0f = %.0f - %s", number1, operation, number2, result, evenOrOdd);
                break;
            case "*":
                result = number1 * number2;
                if (result % 2 == 0) {
                    evenOrOdd = "even";
                } else {
                    evenOrOdd = "odd";
                }
                System.out.printf("%.0f %s %.0f = %.0f - %s", number1, operation, number2, result, evenOrOdd);
                break;
            case "/":
                if (number2 == 0) {
                    System.out.printf("Cannot divide %.0f by zero", number1);
                } else {
                    result = number1 / number2;
                    System.out.printf("%.0f %s %.0f = %.2f", number1, operation, number2, result);
                }

                break;
            case "%":
                if (number2 == 0) {
                    System.out.printf("Cannot divide %.0f by zero", number1);
                } else {
                    result = number1 % number2;
                    System.out.printf("%.0f %s %.0f = %.0f", number1, operation, number2, result);
                }

                break;
        }
       /* if (evenOrOdd.equals("even") || evenOrOdd.equals("odd")) {
            System.out.printf("%d %s %d = %.f – %s", number1, operation, number2, result, evenOrOdd);
        } else {
            System.out.printf("%d %s %d = %.2f", number1, operation, number2, result);
        } */
    }
}
