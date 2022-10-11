import java.util.Arrays;
import java.util.Scanner;

public class MergeSort05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[] sortedArr = mergeSort(input);
        Arrays.stream(sortedArr).forEach(n -> System.out.printf("%d ", n));
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int[] partitionOne = new int[array.length / 2];
        int[] partitionTwo = new int[array.length - partitionOne.length];

        System.arraycopy(array, 0, partitionOne, 0, partitionOne.length);

        if (array.length - partitionOne.length >= 0)
            System.arraycopy(array, partitionOne.length, partitionTwo, 0, array.length - partitionOne.length);
        partitionOne = mergeSort(partitionOne);
        partitionTwo = mergeSort(partitionTwo);

        return mergeSortedArrays(partitionOne, partitionTwo);


    }

    private static int[] mergeSortedArrays(int[] partitionOne, int[] partitionTwo) {
        int[] mainArr = new int[partitionOne.length + partitionTwo.length];
        int partitionOneIndex = 0;
        int partitionTwoIndex = 0;

        while (partitionOneIndex < partitionOne.length && partitionTwoIndex < partitionTwo.length) {
            if(partitionOne[partitionOneIndex] < partitionTwo[partitionTwoIndex]) {
                mainArr[partitionOneIndex + partitionTwoIndex] = partitionOne[partitionOneIndex];
                partitionOneIndex++;
            }else {
                mainArr[partitionOneIndex + partitionTwoIndex] = partitionTwo[partitionTwoIndex];
                partitionTwoIndex++;
            }
        }

        while (partitionOneIndex < partitionOne.length) {
            mainArr[partitionOneIndex + partitionTwoIndex] = partitionOne[partitionOneIndex];
            partitionOneIndex++;
        }

        while (partitionTwoIndex < partitionTwo.length) {
            mainArr[partitionOneIndex + partitionTwoIndex] = partitionTwo[partitionTwoIndex];
            partitionTwoIndex++;
        }
        return mainArr;
    }
}
