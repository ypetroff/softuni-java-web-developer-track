import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equalsIgnoreCase("end")) {
           String[] currentCommand = command.split(" ");

            int number = Integer.parseInt(currentCommand[1]);
            if (currentCommand[0].equalsIgnoreCase("Delete")) {

                deleteElements(listOfNumbers,number);
            }else {
                int index = Integer.parseInt(currentCommand[2]);

                insertElement(listOfNumbers, number, index);
            }
            command = scanner.nextLine();
        }

        String output = listOfNumbers.toString()
                .replaceAll("[\\[\\],]", "");

        System.out.println(output);
    }

    private static void deleteElements(List<Integer> listOfNumbers, int number) {
        listOfNumbers.removeIf(p -> p.equals(number));
    }

    private static void insertElement(List<Integer> listOfNumbers, int number, int index) {
        listOfNumbers.add(index, number);
    }
}
