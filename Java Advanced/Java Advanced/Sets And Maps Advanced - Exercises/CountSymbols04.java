import java.util.*;

public class CountSymbols04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       Map<Character, Integer> map = new TreeMap<>();
        char[] input = scanner.nextLine().toCharArray();
        for (char c : input) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        map.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
