import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> deck1 = fillDeck(scanner);
        Set<Integer> deck2 = fillDeck(scanner);

        int round = 50;

        while (round-- > 0) {
            int cardFromDeck1 = getTopCard(deck1);
            removeCard(deck1, cardFromDeck1);
            int cardFromDeck2 = getTopCard(deck2);
            removeCard(deck2, cardFromDeck2);
            if(cardFromDeck1 > cardFromDeck2) {
                addCards(deck1, cardFromDeck1, cardFromDeck2);

            }else if(cardFromDeck1 < cardFromDeck2) {
                addCards(deck2, cardFromDeck1, cardFromDeck2);

            }

            if(deck1.isEmpty() || deck2.isEmpty()) {
                break;
            }
        }

        if(deck1.size() > deck2.size()) {
            System.out.println("First player win!");
        }else if(deck1.size() < deck2.size()) {
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }

    }

    private static Set<Integer> fillDeck(Scanner scanner) {
      return Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static int getTopCard(Set<Integer> set) {
//        Iterator<Integer> iterator = set.iterator();
//        return iterator.next();
        return set.stream().findFirst().orElse(0);
    }

    private static void addCards(Set<Integer> deck, int cardOne, int cardTwo) {
        deck.add(cardOne);
        deck.add(cardTwo);
    }

    private static void removeCard(Set<Integer> deck, int card) {
        deck.remove(card);
    }
}
