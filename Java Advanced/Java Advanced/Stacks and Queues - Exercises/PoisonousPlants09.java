import java.util.*;

public class PoisonousPlants09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlants=Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        indexes.push(0);
        int[] days = new int[numberOfPlants];

        for (int i = 1; i < numberOfPlants; i++) {
            int lastDay = 0;
            while (!indexes.isEmpty() && plants[indexes.peek()] >= plants[i]) {
                lastDay = Math.max(lastDay, days[indexes.pop()]);
            }
            if (!indexes.isEmpty()) {
                days[i] = lastDay + 1;
            }
            indexes.push(i);
        }
        System.out.println(getLastDay(days));
    }

    private static int getLastDay(int[] days) {
        return Arrays.stream(days).filter(day -> day >= 0).max().orElse(0);
    }
    }

