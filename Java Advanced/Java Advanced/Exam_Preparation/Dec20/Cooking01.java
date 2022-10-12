package Dec20;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking01 {

    private static int bread = 0, cake = 0, pastry = 0, fruitPie = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(liquids::offer);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredients::push);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int liquid = liquids.poll();
            int ingredient = ingredients.pop();

            int sum = liquid + ingredient;

            if (sum == 25) {
                bread++;
            } else if (sum == 50) {
                cake++;
            } else if (sum == 75) {
                pastry++;
            } else if (sum == 100) {
                fruitPie++;
            } else {
                ingredients.push(ingredient + 3);
            }
        }

        if (bread > 0 && cake > 0 && pastry > 0 && fruitPie > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        String output = liquids.isEmpty()
                ? "none"
                : liquids.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.printf("Liquids left: %s%n", output);

        output = ingredients.isEmpty()
                ? "none"
                : ingredients.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.printf("Ingredients left: %s%n", output);

        System.out.printf("Bread: %d%n" +
                "Cake: %d%n" +
                "Fruit Pie: %d%n" +
                "Pastry: %d", bread, cake, fruitPie, pastry);
    }
}
