import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(secondList);

        List<Integer> combinedList = new ArrayList<>();
        int cycles = Math.min(firstList.size(), secondList.size());

        while (cycles > 0) {
            combinedList.add(firstList.get(0));
            combinedList.add(secondList.get(0));

            firstList.remove(0);
            secondList.remove(0);
            cycles--;
        }
        int number1, number2;
        if (firstList.size() > secondList.size()) {
            number1 = firstList.get(0);
            number2 = firstList.get(1);
        } else {
            number1 = secondList.get(0);
            number2 = secondList.get(1);
        }

        int smallerNumber = Math.min(number1, number2);
        int biggerNumber = Math.max(number1, number2);

        List<Integer> result = new ArrayList<>();

        for (Integer integer : combinedList) {

            if(integer > smallerNumber && integer < biggerNumber) {
                result.add(integer);
            }

        }

        Collections.sort(result);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }

    }
}