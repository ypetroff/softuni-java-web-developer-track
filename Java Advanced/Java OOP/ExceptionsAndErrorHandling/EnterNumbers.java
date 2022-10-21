import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumbers {

    private static final int START = 1;
    private static final int END = 100;
    private static int n;
    private static final List<Integer> numbers = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int currentLowest = START;

        while (numbers.size() < 10) {

            try {
                n = Integer.parseInt(scanner.nextLine());

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Number!");
                continue;
            }

            try {
                currentLowest = readNumber(currentLowest);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static int readNumber(int currentLowest) {

        if (n <= currentLowest || n >= EnterNumbers.END) {
            throw new IllegalArgumentException(String.format("Your number is not in range %d - 100!", currentLowest));
        } else {
            numbers.add(n);
            return n;
        }
    }
}
