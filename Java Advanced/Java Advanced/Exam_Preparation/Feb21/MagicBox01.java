package Feb21;

import java.util.*;

public class MagicBox01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(firstMagicBox::offer);

        ArrayDeque<Integer> secondMagicBox =new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondMagicBox::push);

        List<Integer> collected = new ArrayList<>();

        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {

            int sum = firstMagicBox.peek() + secondMagicBox.peek();

            if(sum % 2 == 0) {
                collected.add(sum);
                firstMagicBox.poll();
            } else {
                firstMagicBox.offer(secondMagicBox.peek());
            }

            secondMagicBox.pop();
        }

        if(firstMagicBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        int claimedItemsSum = collected.stream().mapToInt(Integer::valueOf).sum();

        if (claimedItemsSum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", claimedItemsSum);
        } else {
            System.out.printf("Poor prey... Value: %d", claimedItemsSum);
        }
    }
}
