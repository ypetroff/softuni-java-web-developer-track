import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String command;
        while(!(command = scanner.nextLine()).equals("Party!")) {
            String[] tokens = command.split("\\s+");
            Predicate<String>  predicate = implementConditionAndCriteria(tokens[1], tokens[2]);
            switch (tokens[0]) {
                case "Double":
                    addPerson(people, predicate);

                    break;
                case "Remove":
                 removePerson(people, predicate);
                    break;
            }
        }
        Collections.sort(people);
        if(people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        }else {
        String output = String.join(", ", people);
            System.out.printf("%s are going to the party!", output);
        }
    }

    private static Predicate<String> implementConditionAndCriteria(String condition, String criterion) {

        Predicate<String> output = x -> x .equals("");

        switch (condition) {
            case "StartsWith":
                output = x -> x.startsWith(criterion);
                break;
            case "EndsWith":
                output = x -> x.endsWith(criterion);
                break;
            case "Length":
                output = x -> x.length() == Integer.parseInt(criterion);
                break;
        }
        return output;
    }

    private static void addPerson(List<String> people, Predicate<String> predicate) {
        List<String> temp = new ArrayList<>();
        people.stream().filter(predicate).forEach(temp::add);
        people.addAll(temp);
    }

    private static void removePerson(List<String> people, Predicate<String> predicate) {
        people.removeIf(predicate);
    }
}
