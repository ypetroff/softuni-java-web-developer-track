package Feb20;

import java.util.*;

public class Lootbox01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(firstLootBox::offer);

        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondLootBox::push);

        List<Integer> collectedItems = new ArrayList<>();

        while(!firstLootBox.isEmpty() && !secondLootBox.isEmpty()) {

            int first = firstLootBox.peek();
            int second = secondLootBox.pop();

            int sum = first + second;

            if(sum % 2 == 0) {
                firstLootBox.poll();
                collectedItems.add(sum);
            } else {
                firstLootBox.offer(second);
            }
        }

        if(firstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        int loot = collectedItems.stream().mapToInt(Integer::valueOf).sum();

        if(loot >= 100) {
            System.out.printf("Your loot was epic! Value: %d", loot);
        } else {
            System.out.printf("Your loot was poor... Value: %d", loot);
        }
    }
}
