import java.util.*;

public class SoftUniExamResults10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> examData = new HashMap<>(); //TreeMap -> without thenComparing
        Map<String, Integer> languageData = new HashMap<>();

        while (!input.equalsIgnoreCase("exam finished")) {

            String[] studentData = input.split("-");
            String name = studentData[0];
            if (studentData.length == 3) {

                String language = studentData[1];
                int points = Integer.parseInt(studentData[2]);

                examData.putIfAbsent(name, 0);
                if (examData.get(name) < points) {
                    examData.put(name, points);
                }

                languageData.putIfAbsent(language, 0);
                languageData.put(language, languageData.get(language) + 1);
            } else {
                examData.entrySet().removeIf(student -> student.getKey().equals(name));
                // what if there's submission from user after the ban?
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        examData.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.<String, Integer>comparingByKey()))
                .forEach(x -> System.out.printf("%s | %d%n", x.getKey(), x.getValue()));

        System.out.println("Submissions:");
        languageData.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey())) //TreeMap
                .forEach(x -> System.out.printf("%s - %d%n", x.getKey(), x.getValue()));
    }
}
