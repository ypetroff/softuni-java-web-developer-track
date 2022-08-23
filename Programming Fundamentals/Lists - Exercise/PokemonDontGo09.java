import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Long> listOfNumbers = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        List<Long> removedElements = new ArrayList<>();


        while (listOfNumbers.size() >= 1) {
            int index = Integer.parseInt(scanner.nextLine());
            boolean skipRemoval = false;
            long currentNumber;

            if (index < 0) {
                currentNumber = listOfNumbers.get(0);
                listOfNumbers.set(0, listOfNumbers.get(listOfNumbers.size() - 1));
                index = 0;
                skipRemoval = true;
                modifyList(index, listOfNumbers, removedElements, currentNumber, skipRemoval);

            } else if (index >= listOfNumbers.size()) {
                currentNumber = listOfNumbers.get(listOfNumbers.size() - 1);
                listOfNumbers.set(listOfNumbers.size() - 1, listOfNumbers.get(0));
                index = listOfNumbers.size() - 1;
                skipRemoval = true;
                modifyList(index, listOfNumbers, removedElements, currentNumber, skipRemoval);
            } else {
                currentNumber = listOfNumbers.get(index);
                modifyList(index, listOfNumbers, removedElements, currentNumber, skipRemoval);
            }


             //remove, increase and decrease methods within this method
        }
        long sum = 0;
        for (Long removedElement : removedElements) {
            sum += removedElement;
        }
        System.out.println(sum);

    }

    private static void modifyList(int index, List<Long> listOfNumbers, List<Long> removedElements, long currentNumber, boolean skipRemoval) {

        removedElements.add(currentNumber);
        if (!skipRemoval) {
            listOfNumbers.remove(index);
        }


        for (int i = 0; i < listOfNumbers.size(); i++) {
            long tempNum = listOfNumbers.get(i);
            if (currentNumber >= tempNum) {
                listOfNumbers.set(i, tempNum + currentNumber);
            } else {
                listOfNumbers.set(i, tempNum - currentNumber);
            }
        }


    }
}
