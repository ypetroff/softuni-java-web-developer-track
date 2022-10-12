package Oct21;


import java.util.*;

public class AutumnCocktails01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // I made a mistake which is stack and which is que

        ArrayDeque<Integer> numberOfIngredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(numberOfIngredients::offer);

        ArrayDeque<Integer> freshnessOfIngredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(freshnessOfIngredients::push);

        Map<String, List<Integer>> cocktail = new HashMap<>() {{
            put("Pear Sour", Arrays.asList(150, 0));
            put("The Harvest", Arrays.asList(250, 0));
            put("Apple Hinny", Arrays.asList(300, 0));
            put("High Fashion", Arrays.asList(400, 0));
        }};

        while (!numberOfIngredients.isEmpty() && !freshnessOfIngredients.isEmpty()) {

            if (numberOfIngredients.peek() == 0) {
                numberOfIngredients.poll();
                continue;
            }

            int result = numberOfIngredients.peek() * freshnessOfIngredients.pop();

            boolean addCocktail = cocktail.values().stream().anyMatch(freshness -> freshness.get(0) == result);

            if (addCocktail) {
                cocktail.entrySet().stream()
                        .filter(freshness -> freshness.getValue().get(0) == result)
                        .forEach(x -> {
                            cocktail.put(x.getKey(), Arrays.asList(x.getValue().get(0), x.getValue().get(1) + 1));
                            numberOfIngredients.poll();
                        });
            } else {
                numberOfIngredients.offer(numberOfIngredients.poll() + 5);
            }

        }

        long cocktailsMade = cocktail.values().stream().filter(x -> x.get(1) > 0).count();

        if (cocktailsMade > 3) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!numberOfIngredients.isEmpty()) {
            int sum = 0;
            for (Integer ingredient : numberOfIngredients) {
                sum += ingredient;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        cocktail.entrySet().stream().filter(x -> x.getValue().get(1) > 0).sorted(Map.Entry.comparingByKey())
                .forEach(x -> System.out.printf("# %s --> %d%n", x.getKey(), x.getValue().get(1)));

    }
}
