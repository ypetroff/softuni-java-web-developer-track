package Apr21;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets01 {

    private static final int MINIMAL_BOUQUETS_COUNT = 5;
    private static int sum = 0, bouquets = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tulipsStack::push);

        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(daffodilsQueue::offer);

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {

            int tulip = tulipsStack.pop();
            int daffodil = daffodilsQueue.poll();


            arrangeBouquets(tulip, daffodil);

        }

        bouquets += sum / 15;

        if(bouquets >= MINIMAL_BOUQUETS_COUNT) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", MINIMAL_BOUQUETS_COUNT - bouquets);
        }
    }

    private static void arrangeBouquets(int tulip, int daffodil) {

        int currentSum = tulip + daffodil;

        if (currentSum == 15) {
            bouquets++;
        } else if (currentSum > 15) {
            arrangeBouquets(tulip - 2, daffodil);
        } else {
            sum += currentSum;
        }

    }
}
