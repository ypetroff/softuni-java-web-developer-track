import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
      //  String temp = input.replace(" ", "");
        String[] expression = input.split("");
        ArrayDeque<Integer> startIndex = new ArrayDeque<>();

        for (int i = 0; i < expression.length; i++) {
            if (expression[i].equals("(")) {
                startIndex.push(i);
            } else if (expression[i].equals(")")) {
                System.out.println(input.substring(startIndex.pop(), i + 1));
            }
        }
    }
}
