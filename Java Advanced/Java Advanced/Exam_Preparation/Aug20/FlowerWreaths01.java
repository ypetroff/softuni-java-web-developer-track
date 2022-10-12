package Aug20;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths01 {

    private static final int MINIMUM_WREATHS = 5;

    private static int wreaths = 0, sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(lilies::push);

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(roses::offer);


        while (!lilies.isEmpty() && !roses.isEmpty()) {

            int lily = lilies.pop();
            int rose = roses.poll();

            makeWreaths(lily, rose);
        }

        wreaths+= sum / 15;

        if(wreaths >= MINIMUM_WREATHS) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", MINIMUM_WREATHS - wreaths);
        }
    }

    private static void makeWreaths(int lily, int rose) {

        int currentSum = lily + rose;

        if (currentSum == 15) {
            wreaths++;
        } else if (currentSum < 15) {
            sum += currentSum;
        } else {
            makeWreaths(lily - 2, rose);
        }
    }
}
