import java.util.Scanner;

public class RepeatStrings02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : input) {
            stringBuilder.append(printWordNTimes(word));
        }
        System.out.println(stringBuilder);
    }

    private static String printWordNTimes(String word) {
        return word.repeat(word.length());//word + word.repeat(Math.max(0, word.length() - 1));
    }
}
