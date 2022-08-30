import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        String[] phrases = {"Excellent product.",
                            "Such a great product.",
                            "I always use that product.",
                            "Best product of its category.",
                            "Exceptional product.",
                            "I can’t live without this product."};

        String[] events = {"Now I feel good.",
                            "I have succeeded with this product.",
                            "Makes miracles. I am happy of the results!",
                            "I cannot believe but now I feel awesome.",
                            "Try it yourself, I am very satisfied.",
                            "I feel great!"};

        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

       Random myRandom = new Random();

        for (int i = 0; i < numberOfMessages; i++) {
            String usedPhrase = phrases[myRandom.nextInt(phrases.length)];
            String usedEvent = events[myRandom.nextInt(events.length)];
            String usedAuthor = authors[myRandom.nextInt(authors.length)];
            String usedCity = cities[myRandom.nextInt(cities.length)];

            System.out.printf("%s %s %s - %s.%n", usedPhrase, usedEvent, usedAuthor, usedCity);
        }
    }
}
