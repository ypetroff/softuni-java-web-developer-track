import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced05 {
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
    }

    private static void readCommand(String[] currentCommand, List<Integer> numbers) {
        switch (currentCommand[0]) {
            case "contains":
                searchForNumber(currentCommand[1], numbers);
                break;
            case "print":
                if(currentCommand[1].equalsIgnoreCase("even")) {
                    printAllEvenNumbers(numbers);
                } else {
                    printAllOddNumbers(numbers);
                }
                break;
            case "get":
                printSum(numbers);
                break;
            case "filter":
                checkThecondition(currentCommand[1], currentCommand[2], numbers);
                break;
        }
        System.out.println();
    }

    private static void searchForNumber(String numberToLookFor, List<Integer> numbers) {
        int findNumber = Integer.parseInt(numberToLookFor);
        boolean isThere = numbers.contains(findNumber);
//        boolean hasSuchNumber = false;
//        for (Integer number : numbers) {
//            if (findNumber == number) {
//                hasSuchNumber = true;
//                break;
//            }
      //  }
        if (isThere) {
            System.out.print("Yes");
        }else {
            System.out.print("No such number");
        }
    }

    private static void printAllEvenNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
    }

    private static void printAllOddNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number % 2 != 0) {
                System.out.print(number + " ");
            }
        }
    }

    private static void printSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum+=number;
        }
        System.out.print(sum);
    }

    private static void checkThecondition(String condition, String num, List<Integer> numbers) {
        int conditionNumber = Integer.parseInt(num);
        switch (condition) {

            case "<":
                for (Integer listNumber : numbers) {
                    if (conditionNumber > listNumber) {
                        System.out.print(listNumber + " ");
                    }
                }
                break;
            case ">":
                for (Integer listNumber : numbers) {
                    if (conditionNumber < listNumber) {
                        System.out.print(listNumber + " ");
                    }
                }
                break;
            case ">=":
                for (Integer listNumber : numbers) {
                    if (conditionNumber <= listNumber) {
                        System.out.print(listNumber + " ");
                    }
                }
                break;
            case "<=":
                for (Integer listNumber : numbers) {
                    if (conditionNumber >= listNumber) {
                        System.out.print(listNumber + " ");
                    }
                }
                break;
        }
    }
}
