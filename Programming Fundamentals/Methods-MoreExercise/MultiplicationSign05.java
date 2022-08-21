import java.util.Scanner;

public class MultiplicationSign05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1= Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());



        printAnswer(num1, num2, num3);
    }

    private static void printAnswer(int num1, int num2, int num3) {
        boolean isZero = findZero(num1, num2, num3);
        int counterOfNegativeNumbers = 0;
        counterOfNegativeNumbers +=   findNegative(num1);
        counterOfNegativeNumbers +=   findNegative(num2);
        counterOfNegativeNumbers +=   findNegative(num3);

        if(isZero) {
            System.out.println("zero");
        } else {
            if (counterOfNegativeNumbers % 2 !=0 ) {
                System.out.println("negative");
            }else {
                System.out.println("positive");
            }
        }


    }

    private static boolean findZero(int num1, int num2, int num3) {

        return num1 == 0 || num2 == 0 || num3 == 0;
    }

    private static int findNegative(int currentNumber) {
        if (currentNumber < 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
