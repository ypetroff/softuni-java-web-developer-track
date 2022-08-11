import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class lis04_without_methods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> lis = new ArrayList<>();
        List<Integer> lisSaved = new ArrayList<>();
        List<Integer> lisLongest = new ArrayList<>();
        int tempPosition = 0, position = 0, winnerPosition = 0;


        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                lis.add(numbers[i]);
                lisSaved.addAll(lis);
            } else {
                lis.clear();
                lis.add(numbers[i]);
                lisSaved.clear();
                lisSaved.addAll(lis);
            }
            for (int j = i + 1; j < numbers.length; j++) {

                // int index = lis.size() - 1;
                if (lis.get(lis.size() - 1) < numbers[j]) {
                    lis.add(numbers[j]);
                    if (lis.size() == 2) { //see later
                        tempPosition = i;
                    }
                    position = LongestIncreasingSubsequence04.getWinnerPosition(lis, lisSaved, tempPosition, position);
                } else if (lis.get(lis.size() - 1) == numbers[j]) {
                    continue;
                }else LongestIncreasingSubsequence04.lisParameters(numbers, lis, lisSaved, j);
            }
            winnerPosition = LongestIncreasingSubsequence04.getWinnerPosition(lisSaved, lisLongest, position, winnerPosition);
        }
        for (Integer integer : lisLongest) {
            System.out.print(integer + " ");
        }

    }
}