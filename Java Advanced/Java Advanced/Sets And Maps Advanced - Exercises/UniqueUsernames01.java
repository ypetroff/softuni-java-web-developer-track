import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> uniqueUserNames = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            uniqueUserNames.add(scanner.nextLine());
        }
        uniqueUserNames.forEach(System.out::println);
    }
}
