import java.text.CollationElementIterator;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AcademyGraduation08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentDossier = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

            studentDossier.putIfAbsent(name, new ArrayList<>());
            studentDossier.put(name, takeGrades(grades));
        }

        studentDossier.forEach((k, v) -> System.out.printf("%s is graduated with %s%n", k, average(v)));
    }

    private static List<Double> takeGrades(double[] grades) {
        List<Double> result = new ArrayList<>();

        for (double grade : grades) {
            result.add(grade);
        }
        return result;
    }

    private static double average(List<Double> v) {
        double sum = 0;
        for (Double aDouble : v) {
            sum+= aDouble;
        }
        return sum / v.size();
    }
}
