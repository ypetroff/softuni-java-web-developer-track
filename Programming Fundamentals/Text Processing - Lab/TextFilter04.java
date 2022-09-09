import java.util.Scanner;

public class TextFilter04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            while (text.contains(bannedWord)) {
                String replacer = countingStars(bannedWord);
                text = text.replace(bannedWord, replacer);
            }
        }
        System.out.println(text);
    }

    private static String countingStars(String word) {
        return  "*".repeat(word.length()); // or StringBuilder
    }
}
