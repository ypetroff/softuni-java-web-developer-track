import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSubsequence04 {
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
            } else {
                lis.clear();
                lis.add(numbers[i]);
                lisSaved.clear();
            }
            lisSaved.addAll(lis);
            for (int j = i + 1; j < numbers.length; j++) {

                // int index = lis.size() - 1;
                if (lis.get(lis.size() - 1) < numbers[j]) {
                    lis.add(numbers[j]);
                    if (lis.size() == 2) { //see later
                        tempPosition = i;
                    }
                    position = getWinnerPosition(lis, lisSaved, tempPosition, position);
                }else {
                    lisParameters(numbers, lis, lisSaved, j);
                }
            }
            winnerPosition = getWinnerPosition(lisSaved, lisLongest, position, winnerPosition);
        }
        for (Integer integer : lisLongest) {
            System.out.print(integer + " ");
        }
    }

    static int getWinnerPosition(List<Integer> lisSaved, List<Integer> lisLongest, int position, int winnerPosition) {
        if (lisSaved.size() > lisLongest.size()) {
            lisLongest.clear();
            lisLongest.addAll(lisSaved);
            winnerPosition = position;
        } else if (lisSaved.size() == lisLongest.size() && position < winnerPosition) {
            lisLongest.clear();
            lisLongest.addAll(lisSaved);
            winnerPosition = position;
        }
        return winnerPosition;
    }

    static void lisParameters(int[] numbers, List<Integer> lis, List<Integer> lisSaved, int j) {
        if (lis.get(lis.size() - 1) > numbers[j]) {
            boolean isBigger = true;
            while (isBigger) {

                if (lis.size() - 1 == 0) {
                    /*  if(lisSaved.size() > 1) { */
                    lis.clear();
                    lis.addAll(lisSaved);
                    /*  } */
                    break;
                }
                lis.remove(lis.size() - 1);

                if (lis.get(lis.size() - 1) < numbers[j]) {
                    isBigger = false;
                    lis.add(numbers[j]);
                } else if (lis.get(lis.size() - 1) == numbers[j]) {
                    lis.clear();
                    lis.addAll(lisSaved);
                    break;
                }
            }
        }
    }
}

