import java.util.Arrays;
import java.util.Scanner;

public class WordFilter04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Arrays.stream(words)
                .filter(word -> word.length() % 2 ==0)
                .forEach(System.out::println);

//        String[] input = Arrays.stream(scanner.nextLine()
//                .split("\\s+"))
//                .filter(p -> p.length() % 2 == 0)
//                .toArray(String[]::new);
//
//        Arrays.stream(input).forEach(System.out::println);
    }
}
