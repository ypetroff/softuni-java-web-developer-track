import java.util.*;

public class OddOccurrences03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase(Locale.ROOT);

        String[] words = input.split("\\s+");
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String word : words) {

            map.putIfAbsent(word, 0);
            map.put(word, map.get(word) + 1);

        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                sb.append(entry.getKey());
                sb.append(" ");
            }
        }
        String output = sb.toString()
                .trim()
                .replaceAll(" ", ", ");
        System.out.println(output);
    }
}
