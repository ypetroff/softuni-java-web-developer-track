import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> train = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equalsIgnoreCase("end")) {

            String[] currentCommand = command.split(" ");

            if (currentCommand.length == 2) {
                int newWagon = Integer.parseInt(currentCommand[1]);

               train =  AddAWagon(train, newWagon, maxCapacity);
            } else {
                int newPassengers = Integer.parseInt(currentCommand[0]);

                train = boardThePassengers(train, newPassengers, maxCapacity);
            }
            command = scanner.nextLine();
        }
        String output = train.toString().replaceAll("[\\[\\],]", "");
        System.out.println(output);
    }


    private static List<Integer> AddAWagon(List<Integer> train, int add, int maxCapacity) {

       add = checkTheCapacity (add, maxCapacity);

        train.add(add);
        return train;
    }

    private static int checkTheCapacity(int add, int maxCapacity) {
        if (add > maxCapacity) {
            add = maxCapacity;
        }
        return add;
    }

    private static List<Integer> boardThePassengers(List<Integer> train, int add, int maxCapacity) {
        for (int i = 0; i < train.size(); i++) {
            if (train.get(i) + add <= maxCapacity) {
                int boardingPassengers = train.get(i) + add;
                train.set(i, boardingPassengers);
                break;
            }
        }
        return train;
    }
}
