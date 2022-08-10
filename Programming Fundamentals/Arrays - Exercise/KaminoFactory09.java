import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KaminoFactory09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int longestSubsequenceOfOnes = 0, startingIndex = length, bestSum = 0, sample = 0, bestSample = 0;
        int[] chosenDNA = new int[length - 1];

        while (!input.equalsIgnoreCase("Clone them!")) {
            sample++;

            int[] DNA = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int greaterSum = 0;
            for (int i : DNA) {
                if (i == 1) {
                    greaterSum++;
                }
            }

            int longestSubsequenceForThisArray = 0, counter = 0, sIndexThisArr = 0;

            for (int i = length - 1; i >= 0 ; i--) {
                if (DNA[i] == 0) {
                    counter = 0;
                } else {
                    counter++;
                    if (counter > longestSubsequenceForThisArray) {
                        longestSubsequenceForThisArray = counter;
                        sIndexThisArr = i;
                    }
                }



                if (longestSubsequenceForThisArray > longestSubsequenceOfOnes) {
                    longestSubsequenceOfOnes = longestSubsequenceForThisArray;
                    startingIndex = sIndexThisArr;
                    bestSum = greaterSum;
                    chosenDNA = DNA;
                    bestSample = sample;
                }else if (longestSubsequenceForThisArray == longestSubsequenceOfOnes && sIndexThisArr < startingIndex) {
                    startingIndex = sIndexThisArr;
                    bestSum = greaterSum;
                    chosenDNA = DNA;
                    bestSample = sample;
                } else if (longestSubsequenceForThisArray == longestSubsequenceOfOnes && sIndexThisArr == startingIndex && greaterSum > bestSum) {
                    bestSum = greaterSum;
                    chosenDNA = DNA;
                    bestSample = sample;
                }
            }

            input = scanner.nextLine();
        }
        String output = Arrays.stream(chosenDNA)
                .mapToObj(String ::valueOf)
                .collect(Collectors.joining(" "));

        System.out.printf("Best DNA sample %s with sum: %s.%n%s", bestSample, bestSum, output);
    }
}
