package Dec21;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);

        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(females::offer);

        int matches = 0;

        while(!males.isEmpty() && !females.isEmpty()) {

            int male = males.peek();
            int female = females.peek();

            boolean validMale = isValid(male);
            boolean validFemale = isValid(female);

            if(!validMale) {
                males.pop();
                continue;
            } else if (!validFemale) {
                females.poll();
                continue;
            }

            boolean specialCase = divBy25(male);

            if(specialCase) {

                males.pop();

                if(!males.isEmpty()) {
                    males.pop();
                }

                continue;
            }

            specialCase = divBy25(female);

            if(specialCase) {

                females.poll();

                if(!females.isEmpty()) {
                    females.poll();
                }

                continue;
            }

            matches = getMatches(males, females, matches, male, female);

        }

        System.out.printf("Matches: %d%n", matches);

        String malesLeft = males.isEmpty()
                ? "none"
                : males.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.printf("Males left: %s%n", malesLeft);

        String femalesLeft = females.isEmpty()
                ? "none"
                : females.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.printf("Females left: %s%n", femalesLeft);
    }


    private static boolean isValid(int number) {
        return number > 0;
    }

    private static boolean divBy25(int male) {

        return male % 25 == 0;
    }

    private static int getMatches(ArrayDeque<Integer> males, ArrayDeque<Integer> females, int matches, int male, int female) {
        if(male == female) {

            males.pop();

            matches++;

        }else {
            males.push(males.pop() - 2);
        }

        females.poll();
        return matches;
    }
}
