import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while(!command.equalsIgnoreCase("finish")) {
            String[] instructions = command.split(" ");
            String action = instructions[0];
            int value = Integer.parseInt(instructions[1]);

            if(action.equalsIgnoreCase("add")) {
                addNumber(listOfNumbers, value);
            } else if (action.equalsIgnoreCase("remove")) {
                removeNumber(listOfNumbers, value);
            }else if (action.equalsIgnoreCase("replace")) {
                int replacement = Integer.parseInt(instructions[2]);
                replaceNumber(listOfNumbers, value, replacement);
            } else if (action.equalsIgnoreCase("collapse")) {
                collapseNumbers(listOfNumbers, value);
            }


            command = scanner.nextLine();
        }

        String output = listOfNumbers.toString().replaceAll("[\\[\\],]", "");
        System.out.println(output);
    }

    private static void addNumber(List<Integer> listOfNumbers, int value) {
        listOfNumbers.add(value);
    }

    private static void removeNumber(List<Integer> listOfNumbers, int value) {
        for (Integer listOfNumber : listOfNumbers) {
            if(listOfNumber.equals(value)) {
                listOfNumbers.remove(listOfNumber);
                break;
            }
        }
    }

    private static void replaceNumber(List<Integer> listOfNumbers, int value, int replacement) {
        for (int i = 0; i < listOfNumbers.size(); i++) {
            if(listOfNumbers.get(i).equals(value)) {
                listOfNumbers.set(i, replacement);
                break;
            }
        }
    }

    private static void collapseNumbers(List<Integer> listOfNumbers, int value) {
        listOfNumbers.removeIf(number -> number < value);
    }
}
