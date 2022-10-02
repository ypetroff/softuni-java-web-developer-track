import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        Predicate<String> predicate = x -> Character.isUpperCase(x.charAt(0));

        List<String> collectedWords = Arrays.stream(words).filter(predicate).collect(Collectors.toList());
        System.out.println(collectedWords.size());
        collectedWords.forEach(System.out::println);
    }
}
