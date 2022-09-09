import java.util.Scanner;

public class Substring03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordToRemove = scanner.nextLine();
        String text = scanner.nextLine();

        while (text.contains(wordToRemove)) {
           text = removeWord(text, wordToRemove);
        }
        System.out.println(text);
    }

    private static String removeWord(String text, String wordToRemove) {
        int startIndex = text.indexOf(wordToRemove);
        int endIndex = startIndex + wordToRemove.length();
        return text.substring(0, startIndex) + text.substring(endIndex); // or text.replace(startIndex)
    }
}
