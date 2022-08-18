import java.util.Scanner;

public class MultiplyEvensByOdds10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNumber = Math.abs(Integer.parseInt(scanner.nextLine()));

        int result = getMultipleOfEvensAndOdds(inputNumber);

        System.out.println(result);
    }

    private static int getMultipleOfEvensAndOdds(int inputNumber) {
        int sumOdds = sumOfOdds(inputNumber);
        int sumEvens = sumOfEvens(inputNumber);
                
                return sumEvens * sumOdds;
    }

    private static int sumOfOdds(int inputNumber) {
        int OddsSum = 0;
        while (inputNumber != 0) {
            int currentNum = inputNumber % 10;
            if (currentNum % 2 != 0) {
                OddsSum+=currentNum;
            }
            inputNumber/= 10;
        }
        return OddsSum;
    }

    private static int sumOfEvens(int inputNumber) {
       int evensSum = 0;
        while (inputNumber != 0) {
           int currentNum = inputNumber % 10;
           if (currentNum % 2 == 0) {
               evensSum+=currentNum;
           }
           inputNumber/= 10;
        }
        return evensSum;
    }
}
