import java.util.*;

public class CountCharsInAString01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] chars = scanner.nextLine()
                .replaceAll(" ", "")
                .toCharArray();

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char aChar : chars) {
            map.putIfAbsent(aChar, 0);
            map.put(aChar, map.get(aChar) + 1);
        }


            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
