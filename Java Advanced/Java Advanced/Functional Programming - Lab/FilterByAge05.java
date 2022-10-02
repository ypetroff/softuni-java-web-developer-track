import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> people = getPeopleInfo(numberOfPeople, scanner);

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        people.entrySet()
                .stream()
                .filter(ageCondition(condition, age))
                .forEach(formatting(format));
    }

    private static Map<String, Integer> getPeopleInfo(int numberOfPeople, Scanner scanner) {
        Map<String, Integer> output = new LinkedHashMap<>();
        for (int i = 0; i < numberOfPeople; i++) {
            String[] nameAndAge = scanner.nextLine().split(",\\s+");
            output.put(nameAndAge[0], Integer.parseInt(nameAndAge[1]));
        }
        return output;
    }

    private static Predicate<Map.Entry<String, Integer>> ageCondition(String condition, int age) {
        if (condition.equals("younger")) {
            return x -> x.getValue() <= age;
        } else {
            return x -> x.getValue() >= age;
        }
    }

    private static Consumer<Map.Entry<String, Integer>> formatting(String format) {
        switch (format) {
            case "name":
                return e -> System.out.println(e.getKey());
            case "age":
                return  e-> System.out.println(e.getValue());
            default:
                return  e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue());
        }
    }
}
