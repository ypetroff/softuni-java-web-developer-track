package Aug21;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PastryShop01 {

    private static int biscuit = 0, cake = 0, pastry = 0, pie = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(liquidsQueue::offer);

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredientsStack::push);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();

            int result = liquid + ingredient;

            if (result == 25) {
                biscuit++;
            } else if (result == 50) {
                cake++;
            } else if (result == 75) {
                pastry++;
            } else if (result == 100) {
                pie++;
            } else {
                ingredientsStack.push(ingredient + 3);
            }
        }

        if (biscuit > 0 && cake > 0 && pastry > 0 && pie > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        String output = liquidsQueue.isEmpty()
                ? "Liquids left: none"
                : "Liquids left: ".concat(liquidsQueue.stream()
                .map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(output);

        output = ingredientsStack.isEmpty()
                ? "Ingredients left: none"
                : "Ingredients left: ".concat(ingredientsStack.stream()
                .map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(output);

        System.out.printf("Biscuit: %d%nCake: %d%nPie: %d%nPastry: %d%n", biscuit, cake, pie, pastry);


    }
}
