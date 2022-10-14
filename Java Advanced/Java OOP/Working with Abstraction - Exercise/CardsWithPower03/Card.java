package CardsWithPower03;




import java.util.Arrays;

public class Card {

    private final String cardRank;
    private final String cardSuit;

    public Card(String cardRank, String cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int power() {

        int rankPower = Arrays.stream(CardRank.values())
                .filter(rank -> rank.name().equals(cardRank))
                .limit(1).mapToInt(CardRank::getPower).findAny().orElse(0);

        int suitPower = Arrays.stream(CardSuit.values())
                .filter(suit -> suit.name().equals(cardSuit))
                .limit(1).mapToInt(CardSuit::getPower).findAny().orElse(0);

        return rankPower + suitPower;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", cardRank, cardSuit, this.power());
    }
}
