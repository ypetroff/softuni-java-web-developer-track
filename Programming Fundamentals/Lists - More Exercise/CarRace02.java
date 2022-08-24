import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> track = Arrays.stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> leftTrack = track.subList(0, track.size() / 2);
        List<Integer> rightTrack = track.subList(track.size() / 2 + 1, track.size());
        Collections.reverse(rightTrack);

        double leftRacerTime = takeTime(leftTrack);
        double rightRacerTime = takeTime(rightTrack);
        BigDecimal left = BigDecimal.valueOf(leftRacerTime);
        BigDecimal right = BigDecimal.valueOf(rightRacerTime);
        left = left.setScale(1, RoundingMode.DOWN);
        right = right.setScale(1, RoundingMode.DOWN);


        if (leftRacerTime < rightRacerTime) {
            System.out.print("The winner is left with total time: " + left);
        } else if (leftRacerTime > rightRacerTime) {
            System.out.print("The winner is right with total time: " + right);
        }
    }

    private static double takeTime(List<Integer> track) {
        double sum = 0;
        for (Integer integer : track) {
            if (integer == 0 && sum != 0) {
                sum *= .8;
            } else {
                sum += integer;
            }
        }

        return sum;
    }
}
