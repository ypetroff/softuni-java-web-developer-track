import java.util.*;


public class Courses06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;

        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!"end".equalsIgnoreCase(command = scanner.nextLine())) {
            String[] newData = command.split(" : ");
            String course = newData[0];
            String student = newData[1];

            courses.putIfAbsent(course, new ArrayList<>());
            courses.get(course).add(student);
        }
        courses.entrySet().stream()
                .sorted((student1, student2) -> Integer.compare(student2.getValue().size(), student1.getValue().size()))
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().stream()
                            .sorted(String::compareTo)
                            .forEach(x -> System.out.printf("-- %s%n", x));
                });
    }

}
