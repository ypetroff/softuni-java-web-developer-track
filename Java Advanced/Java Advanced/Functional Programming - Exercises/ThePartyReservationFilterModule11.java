import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> invitations = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Set<String> filters = new HashSet<>();

        String command;
        while (!(command = scanner.nextLine()).equals("Print")) {
            String[] tokens = command.split(";");

            if (tokens[0].contains("Add")) {
                filters.add(tokens[1] + "," + tokens[2]);
            } else if (tokens[0].contains("Remove")) {
                filters.remove(tokens[1] + "," + tokens[2]);
            }
        }
        filters.forEach(x -> invitations.removeIf(implementConditions(x)));
        System.out.println(String.join(" ", invitations));
    }

    private static Predicate<String> implementConditions(String predicate) {
        String[] conditions = predicate.split(",");
        String condition = conditions[0];
        String criterion = conditions[1];

        if (condition.contains("Starts with")) {
            return x -> x.startsWith(criterion);
        } else if (condition.contains("Ends with")) {
            return x -> x.endsWith(criterion);
        } else if (condition.contains("Length")) {
            return x -> x.length() == Integer.parseInt(criterion);
        } else {
            return x -> x.contains(criterion);
        }
    }

}
