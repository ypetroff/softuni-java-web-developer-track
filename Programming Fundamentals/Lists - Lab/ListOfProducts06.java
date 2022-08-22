import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOfProducts06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        List<String> items = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            String currentInput = scanner.nextLine();
            items.add(currentInput);
        }

        printTheList(items);
    }

    private static void printTheList(List<String> items) {
        Collections.sort(items);
        for (int i = 0; i < items.size() ; i++) {
            System.out.printf("%d.%s%n", i + 1, items.get(i));
        }
    }
}
