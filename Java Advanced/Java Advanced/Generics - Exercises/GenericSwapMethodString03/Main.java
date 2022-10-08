package GenericSwapMethodString03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Box<String> box = new Box<>();

        int numberOfElements = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfElements; i++) {
            String str = scanner.nextLine();
            box.add(str);
        }

        int[] swapIndexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int index1 = swapIndexes[0];
        int index2 = swapIndexes[1];
        box.swap(index1, index2);

        System.out.println(box);
    }
}
