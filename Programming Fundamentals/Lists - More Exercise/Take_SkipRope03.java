import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Take_SkipRope03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        List<String> nonDigitList = new ArrayList<>();
        int counter = 0;

            for (String s : input) {
                char symbol = s.charAt(0);

                if (symbol >= 48 && symbol <= 57) {
                    int digit = Integer.parseInt(s);

                    if (counter % 2 == 0) {
                        takeList.add(digit);
                    }else {
                        skipList.add(digit);
                    }
                    counter++;
                } else {
                    nonDigitList.add(s);
                }
        }

            List<String> result = new ArrayList<>();
            int cycles = takeList.size();
        for (int i = 0; i < cycles; i++) {

            takeSymbol(nonDigitList, takeList, result);
            skipSymbol(nonDigitList, skipList);

        }
        String output = result.toString().replaceAll("[\\[\\],\\s]", "");
        System.out.println(output);

    }

    private static void takeSymbol(List<String> nonDigitList, List<Integer> takeList, List<String> result) {
        int cycles = checkIndexValidity(takeList.get(0),nonDigitList.size());
        for (int i = 0; i < cycles; i++) {
            result.add(nonDigitList.get(i));
        }
        removeIndexes(nonDigitList, takeList);
        takeList.remove(0);
    }

    private static void skipSymbol(List<String> nonDigitList, List<Integer> skipList) {
        removeIndexes(nonDigitList,skipList);
        skipList.remove(0);
    }

    private static int checkIndexValidity(Integer integer, int size) {
        if (integer >= size) {
            return size;
        }else {
            return integer;
        }
    }

    private static void removeIndexes(List<String> nonDigitList, List<Integer> listOfNumbers) {
        int cycles = checkIndexValidity(listOfNumbers.get(0), nonDigitList.size());
        while (cycles > 0) {
            nonDigitList.remove(0);
            cycles--;
        }
    }
}
