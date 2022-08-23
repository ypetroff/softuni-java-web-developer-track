import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> deckOne = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> deckTwo = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        
        while (!deckOne.isEmpty() && !deckTwo.isEmpty()) {

            int index = 0;

                compareCards(deckOne, deckTwo, index);

        }

        int sum = 0;
        if (deckOne.isEmpty()) {
           sum = findSum(deckTwo, sum);
            System.out.printf("Second player wins! Sum: %d", sum);
        }else {
            sum = findSum(deckOne, sum);
            System.out.printf("First player wins! Sum: %d", sum);
        }
    }

    private static void compareCards(List<Integer> deckOne, List<Integer> deckTwo, int index) {
        if(deckOne.get(index) > deckTwo.get(index)) {
            deckOne.add(deckOne.get(index));
            deckOne.remove(index);
            deckOne.add((deckTwo.get(index)));
            deckTwo.remove(index);
        }else if (deckOne.get(index) < deckTwo.get(index)) {
            deckTwo.add(deckTwo.get(index));
            deckTwo.remove(index);
            deckTwo.add(deckOne.get(index));
            deckOne.remove(index);


        }else {
            deckOne.remove(index);
            deckTwo.remove(index);
        }
    }

    private static int findSum(List<Integer> winnersDeck, int sum) {
        for (Integer integer : winnersDeck) {
            sum+=integer;

        }
        return sum;
    }
}
