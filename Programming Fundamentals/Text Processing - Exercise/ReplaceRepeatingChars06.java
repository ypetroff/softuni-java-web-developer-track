import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Character> chars = new ArrayList<>();

        for (Character c : input.toCharArray()) {
            chars.add(c);
        }

        for (int i = 0; i < chars.size() - 1; i++) {
            if (chars.get(i) == chars.get(i + 1)) {
                chars.remove(i + 1);
                i--;
            }
        }
        String output = chars.toString().replaceAll("[\\[\\],\\s+]", "");
        System.out.println(output);
    }
}
