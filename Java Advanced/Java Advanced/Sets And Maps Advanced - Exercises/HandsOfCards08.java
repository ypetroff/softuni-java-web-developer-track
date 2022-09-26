import java.util.*;

public class HandsOfCards08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playersAndCards = new LinkedHashMap<>();

        String command;
        while (!"JOKER".equals(command = scanner.nextLine())) {
            String[] newData = command.split(": ");
            String name = newData[0];
            String[] cards = newData[1].split(", ");

            playersAndCards.putIfAbsent(name, new LinkedHashSet<>());
            Collections.addAll(playersAndCards.get(name), cards);
        }

        playersAndCards.forEach((key, value) -> System.out.printf("%s: %d%n", key, getPoints(value)));
    }

    private static int getPoints(Set<String> set) {
        int points = 0;
        for (String s : set) {
            char[] arr = s.toCharArray();

            if (Character.isDigit(arr[0])) {
                if(arr.length < 3) {
                    points += Character.getNumericValue(arr[0]) * MultiplyBy(arr[1]);
                } else {
                    points+= 10 * MultiplyBy(arr[2]);
                }

            } else if (arr[0] == 'J') {
                points += 11 * MultiplyBy(arr[1]);
            } else if (arr[0] == 'Q') {
                points += 12 * MultiplyBy(arr[1]);
            } else if (arr[0] == 'K') {
                points += 13 * MultiplyBy(arr[1]);
            } else if (arr[0] == 'A') {
                points += 14 * MultiplyBy(arr[1]);
            }
        }
        return points;
    }

    private static int MultiplyBy(char c) {
        if (c == 'S') {
            return 4;
       } else if (c == 'H') {
            return 3;
       } else if (c == 'D') {
            return 2;
       } else if (c == 'C') {
            return 1;
        }
        return 0;
    }
}
