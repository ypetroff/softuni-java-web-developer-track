import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs_v2_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] ladyBugIndex = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

    }
}
