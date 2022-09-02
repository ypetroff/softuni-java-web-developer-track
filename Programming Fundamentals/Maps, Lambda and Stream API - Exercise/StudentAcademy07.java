import java.util.*;

public class StudentAcademy07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRows = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsDossier = new LinkedHashMap<>();

        for (int i = 0; i < numberOfRows; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            studentsDossier.putIfAbsent(name, new ArrayList<>());
            studentsDossier.get(name).add(grade);
        }

        Map<String, Double> averageGrade = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : studentsDossier.entrySet()) {
            double average = getAverage(entry.getValue());

            averageGrade.put(entry.getKey(), average);
        }

        averageGrade.entrySet().stream()
                .filter(grade -> grade.getValue() >= 4.5)
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(x -> System.out.printf("%s -> %.2f%n", x.getKey(), x.getValue()));
    }

    private static double getAverage(List<Double> value) {
        double sum = 0;
        for (Double aDouble : value) {
            sum+=aDouble;
        }
        return sum / value.size();
    }
}
