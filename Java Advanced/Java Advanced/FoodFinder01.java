import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FoodFinder01 {

//    private static final String PEAR = "pear", FLOUR = "flour", PORK = "pork", OLIVE = "olive";
//
//     private static int pear = PEAR.length(), flour = FLOUR.length(), pork = PORK.length(), olive = OLIVE.length();

    private static String pear = "pear", flour = "flour", pork = "pork", olive = "olive";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(e -> e.charAt(0)).forEach(vowels::offer);

        ArrayDeque<Character> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(e -> e.charAt(0)).forEach(consonants::push);

        while (!consonants.isEmpty()) {

            char vowel = vowels.poll();
            char consonant = consonants.pop();

            pear = checkWord(pear, vowel, consonant);
            flour = checkWord(flour, vowel, consonant);
            pork = checkWord(pork, vowel, consonant);
            olive = checkWord(olive, vowel, consonant);

            vowels.offer(vowel);
        }

        int count = 0;

        if(pear.isEmpty()) {
            count++;
        }
        if(flour.isEmpty()) {
            count++;
        }
        if(pork.isEmpty()) {
            count++;
        }
        if(olive.isEmpty()) {
            count++;
        }

        System.out.printf("Words found: %d%n", count);

        if(pear.isEmpty()) {
            System.out.println("pear");
        }
        if(flour.isEmpty()) {
            System.out.println("flour");
        }
        if(pork.isEmpty()) {
            System.out.println("pork");
        }
        if(olive.isEmpty()) {
            System.out.println("olive");
        }


    }

    private static String checkWord(String word, char vowel, char consonant) {

        word = word.replaceAll(String.valueOf(vowel), "");
        word = word.replaceAll(String.valueOf(consonant), "");

        return word;
    }
}
