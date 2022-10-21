package numberInRange;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int start = range[0];
        int end = range[1];
        System.out.printf("Range: [%d...%d]%n", start, end);

        boolean validNumber = false;

        while (!validNumber) {
           String n = scanner.nextLine();
            try {
               int currentNumber = Integer.parseInt(n);

                if(currentNumber < start || currentNumber > end) {
                    exceptionMessage(n);
                    continue;
                }

                validNumber = true;
                System.out.println("Valid number: " + n);

            }catch (IllegalArgumentException e) {
                exceptionMessage(n);
            }
        }



    }

    private static void exceptionMessage(String n) {
        System.out.println("Invalid number: " + n);
    }


}
