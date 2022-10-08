package GenericSwapMethodInteger04;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Integer> box = new Box<>();

        int numberOfElements = Integer.parseInt(scanner.nextLine());

        IntStream.range(0, numberOfElements)
                .mapToObj(i -> Integer.parseInt(scanner.nextLine()))
                .forEach(box::add);

        int[] swapIndexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int index1 = swapIndexes[0];
        int index2 = swapIndexes[1];
        box.swap(index1, index2);

        System.out.println(box);
    }
}
