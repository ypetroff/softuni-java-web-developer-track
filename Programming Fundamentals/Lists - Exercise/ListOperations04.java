import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine().trim();

        while (!command.equalsIgnoreCase("end")) {
            String[] currentCommand = command.split(" ");

            if(currentCommand[0].equalsIgnoreCase("add")) {
                int number = Integer.parseInt(currentCommand[1]);
                addNumber(listNumbers,number);

            } else if (currentCommand[0].equalsIgnoreCase("insert")) {
                int number = Integer.parseInt(currentCommand[1]);
                int index = Integer.parseInt(currentCommand[2]);

                boolean isValid = indexCheck(listNumbers, index);

                if(isValid) {
                    insertNumber(listNumbers, number, index);
                } else {
                    System.out.println("Invalid index");
                }

            }else if (currentCommand[0].equalsIgnoreCase("remove")) {
                int index = Integer.parseInt(currentCommand[1]);

                boolean isValid = indexCheck(listNumbers, index);

                if(isValid) {
                    removeNumber(listNumbers, index);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (currentCommand[0].equalsIgnoreCase("shift")) {
                int movePosition = Integer.parseInt(currentCommand[2]);
                if(currentCommand[1].equalsIgnoreCase("left")) {
                    moveLeft(listNumbers, movePosition);
                }else {
                    moveRight(listNumbers, movePosition);
                }
            }

            command = scanner.nextLine().trim();
        }

        String output = listNumbers.toString().replaceAll("[\\[\\],]", "");
        System.out.println(output);
    }

    private static void addNumber(List<Integer> listNumbers, int number) {
        listNumbers.add(number);
    }

    private static void insertNumber(List<Integer> listNumbers, int number, int index) {
        listNumbers.add(index, number);
    }

    private static boolean indexCheck(List<Integer> listNumbers, int index) {
        return index >= 0 && index < listNumbers.size();
    }

    private static void removeNumber(List<Integer> listNumbers, int index) {
        listNumbers.remove(index);
    }

    private static void moveLeft(List<Integer> listNumbers, int position) {

        for (int i = 0; i < position; i++) {
                listNumbers.add(listNumbers.get(0));
                listNumbers.remove(listNumbers.get(0));
        }
    }

    private static void moveRight(List<Integer> listNumbers, int position) {
        int i = 0;
        while (i < position) {
            listNumbers.add(0, listNumbers.get(listNumbers.size() - 1));
            listNumbers.remove(listNumbers.size() - 1);
            i++;
        }
    }
}
