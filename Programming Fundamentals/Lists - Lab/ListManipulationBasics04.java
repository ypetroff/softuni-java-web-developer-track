import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equalsIgnoreCase("end")) {
            String[] currentCommand = command.toLowerCase(Locale.ROOT).split(" ");

            readCommand(currentCommand, numbers);
            command = scanner.nextLine();

        }
        String output = numbers.toString().replaceAll("[\\[\\],]", "");
        System.out.println(output);
    }

    private static void readCommand(String[] currentCommand, List<Integer> numbers) {
        switch (currentCommand[0]) {
            case "add":
                addANumber(currentCommand[1], numbers);
                break;
            case "remove":
                removeANumber(currentCommand[1], numbers);
                break;
            case "removeat":
                removeAtIndex(currentCommand[1], numbers);
                break;
            case "insert":
                specificNumberforIndex(currentCommand[1], currentCommand[2], numbers);
                break;
        }
    }

    private static void addANumber(String number, List<Integer> numbers) {
       int currentNumber = Integer.parseInt(number);
       numbers.add(currentNumber);
    }

    private static void removeANumber(String number, List<Integer> numbers) {
        int currentNumber = Integer.parseInt(number);
        numbers.remove(Integer.valueOf(currentNumber));
    }

    private static void removeAtIndex(String number, List<Integer> numbers) {
        int currentNumber = Integer.parseInt(number);
        numbers.remove(currentNumber);
    }

    private static void specificNumberforIndex(String number, String index, List<Integer> numbers) {
        int currentNumber = Integer.parseInt(number);
        int currentIndex = Integer.parseInt(index);
        numbers.add(currentIndex, currentNumber);
    }
}
