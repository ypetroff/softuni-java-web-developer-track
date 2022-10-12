package June20;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs01 {

    private static final int DATURA_BOMB = 40, CHERRY_BOMB = 60, SMOKE_DECOY_BOMB = 120, MINIMUM_AMOUNT = 3;
    private static int datura = 0, cherry = 0, smoke = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effects = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(effects::offer);

        ArrayDeque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(casings::push);


        while (!effects.isEmpty() && !casings.isEmpty()
                && (datura < MINIMUM_AMOUNT || cherry < MINIMUM_AMOUNT || smoke < MINIMUM_AMOUNT)) {

            int effect = effects.poll();
            int casing = casings.pop();

            makeBomb(effect, casing);
        }

        if(datura >= MINIMUM_AMOUNT && cherry >= MINIMUM_AMOUNT && smoke >= MINIMUM_AMOUNT) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        String output = effects.isEmpty()
                ? "Bomb Effects: empty"
                : "Bomb Effects: ".concat(effects.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(output);

        output = casings.isEmpty()
                ? "Bomb Casings: empty"
                : "Bomb Casings: ".concat(casings.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(output);

        System.out.printf("Cherry Bombs: %d%nDatura Bombs: %d%nSmoke Decoy Bombs: %d", cherry, datura, smoke);
    }

    private static void makeBomb(int effect, int casing) {

        int sum = effect + casing;

        if (sum == DATURA_BOMB) {
            datura++;
        } else if(sum == CHERRY_BOMB) {
            cherry++;
        } else if (sum == SMOKE_DECOY_BOMB) {
            smoke++;
        } else {
            makeBomb(effect, casing - 5);
        }
    }
}
