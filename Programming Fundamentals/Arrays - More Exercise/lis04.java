import java.util.*;
import java.util.stream.Collectors;

public class lis04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] solutions = new int[numbers.length];

        int[] prev = new int[numbers.length];

        int maxSolution = 0, maxSolIndex = 0;

        for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
            int solution = 1;
            int currentNumber = numbers[currentIndex];
            int prevIndex =  -1;

            for (int solutionIndex = 0; solutionIndex < currentIndex; solutionIndex++) {

                int prevNumber = numbers[solutionIndex];
                int prevSolution = solutions[solutionIndex];

                if (currentNumber > prevNumber && solution <= prevSolution) {
                    solution = prevSolution + 1;
                    prevIndex = solutionIndex;
                }
            }
            solutions[currentIndex] = solution;
            prev[currentIndex] = prevIndex;

            if (solution > maxSolution) {
                maxSolution = solution;
                maxSolIndex = currentIndex;
            }
        }
        int index = maxSolIndex;
        List<Integer> result = new ArrayList<>();

        while (index != -1) {
            int currentNumber = numbers[index];
            result.add(currentNumber);
            index = prev[index];
        }
        Collections.reverse(result);

        String output = result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "));

        System.out.println(output);
    }
}
