import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOne = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> listTwo = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> combinedList = new ArrayList<>();

        int cycles = Math.min(listOne.size(), listTwo.size());
        int additionalCycles = Math.max(listOne.size(), listTwo.size());

        combinedList = distributeCommonLengthElements(combinedList, listOne, listTwo, cycles);
        combinedList = getAdditionalNumbers(combinedList, listOne, listTwo, cycles, additionalCycles);

        String output = combinedList.toString()
                        .replaceAll("[\\[\\],]", "");

        System.out.println(output);

    }

    private static List<Integer> distributeCommonLengthElements(List<Integer> combinedList, List<Integer> listOne, List<Integer> listTwo, int cycles) {
        for (int i = 0; i < cycles; i++) {
            combinedList.add(listOne.get(i));
            combinedList.add(listTwo.get(i));
        }
        return combinedList;
    }

    private static List<Integer> getAdditionalNumbers(List<Integer> combinedList, List<Integer> listOne, List<Integer> listTwo, int cycles, int additionalCycles) {

        List<Integer> longerList = findLongerList(listOne, listTwo);

        for (int i = cycles; i < additionalCycles; i++) {
            combinedList.add(longerList.get(i));

        }
        return combinedList;
    }

    private static List<Integer> findLongerList(List<Integer> listOne, List<Integer> listTwo) {
        if (listOne.size() >= listTwo.size()) {
            return listOne;
        } else {
            return listTwo;
        }
    }


}
