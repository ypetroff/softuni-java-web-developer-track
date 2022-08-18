import java.util.Scanner;

public class PrintingTriangle03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNumber = Integer.parseInt(scanner.nextLine());

        printTriangle(inputNumber);
    }

    private static void printTriangle(int inputNumber) {
        printTopHalf(inputNumber);
        printBottomHalf(inputNumber);
    }

    private static void printTopHalf(int inputNumber) {
        for (int i = 1; i < inputNumber; i++) {
            printSingleLine(i);

        }
    }

    private static void printBottomHalf(int inputNumber) {
        for (int i = inputNumber; i >= 1; i--) {
            printSingleLine(i);
        }
    }

    private static void printSingleLine(int length) {
        for (int i = 1; i <= length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
