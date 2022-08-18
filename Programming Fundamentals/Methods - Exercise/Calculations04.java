import java.util.Scanner;

public class Calculations04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        switch (operation) {
            case "add":
                printAddition(firstNumber, secondNumber);
                break;
            case "multiply":
                printMultiplication(firstNumber, secondNumber);
                break;
            case "subtract":
                printSubtraction(firstNumber, secondNumber);
                break;
            case "divide":
                printDivision(firstNumber, secondNumber);
                break;
        }
    }


    private static void printAddition(int numberOne, int numberTwo) {
        int sum;
        sum = numberOne + numberTwo;
        System.out.println(sum);
    }

    private static void printMultiplication(int firstNumber, int secondNumber) {
        int product = firstNumber * secondNumber;
        System.out.println(product);
    }

    private static void printSubtraction(int firstNumber, int secondNumber) {
        int difference = firstNumber - secondNumber;
        System.out.println(difference);
    }

    private static void printDivision(int firstNumber, int secondNumber) {
        int quotient = firstNumber / secondNumber;
        System.out.println(quotient);
    }
}
