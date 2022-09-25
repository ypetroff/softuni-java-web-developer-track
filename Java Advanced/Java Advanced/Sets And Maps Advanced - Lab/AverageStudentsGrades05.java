import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentInfo = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] studentData = scanner.nextLine().split("\\s+");
            studentInfo.putIfAbsent(studentData[0], new ArrayList<>());
            studentInfo.get(studentData[0]).add(Double.parseDouble(studentData[1]));
        }

        studentInfo.forEach((key, value) -> {

            System.out.printf("%s -> ", key);
            value.forEach(v -> System.out.printf("%.2f ", v));
            System.out.printf("(avg: %.2f)%n", average(value));
        });
    }

    private static double average(List<Double> value) {
        double average = 0.0;
        for (Double aDouble : value) {
            average += aDouble;
        }
        return average / value.size();
    }
}
