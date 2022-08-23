import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            String[] currentCommand = command.split("\\s+");
            String action = currentCommand[0];

            if (action.equals("merge")) {
                mergeString(currentCommand[1], currentCommand[2], input);
            } else {
                divideString(currentCommand[1], currentCommand[2], input);
            }
            command = scanner.nextLine();
        }
        for (String s : input) {

            System.out.print(s + " ");

        }
        System.out.println();
    }

    private static void mergeString(String s, String s1, List<String> input) {

        int startIndex = parseToInt(s);
        int endIndex = parseToInt(s1);

        boolean startIsLessThanZero = checkTheBottom(startIndex);
        boolean startIsOutOfBound = outOfBound(startIndex, input);
        boolean endIsLessThanZero = checkTheBottom(endIndex);
        boolean endIsOutOfBound = outOfBound(endIndex, input);

        if (startIsLessThanZero) {
            startIndex = 0;
        }
        if (endIsOutOfBound) {
            endIndex = input.size() - 1;
        }
        if (startIsOutOfBound) {
            startIndex = input.size() - 1;
        }
        if (endIsLessThanZero) {
            endIndex = 0;
        }

        executeTheMerge(startIndex, endIndex, input);

    }


    private static void divideString(String s, String s1, List<String> input) {
        int index = parseToInt(s);
        int partitions = parseToInt(s1);

        executeDivision(index, partitions, input);
    }


    private static int parseToInt(String number) {

        return Integer.parseInt(number);
    }

    private static boolean checkTheBottom(int index) {
        return index < 0;
    }

    private static boolean outOfBound(int index, List<String> input) {
        return index >= input.size();
    }

    private static void executeTheMerge(int startIndex, int endIndex, List<String> input) {
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            sb.append(input.get(i));
        }
        int rotations = endIndex - startIndex;

        while (rotations > 0) {
            input.remove(startIndex);
            rotations--;
        }
        input.set(startIndex, sb.toString());
    }

    private static void executeDivision(int index, int partitions, List<String> input) {


        String temp = input.get(index);
        List<String> currentString = Arrays.stream(temp.split("(?!^)"))
                .map(String::valueOf)
                .collect(Collectors.toList());
        List<String> tempList = new ArrayList<>();
        int elementsPerPartition = currentString.size() / partitions;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < partitions - 1; i++) {
            sb.setLength(0);

            for (int j = 0; j < elementsPerPartition; j++) {
                sb.append(currentString.get(j));
            }
            tempList.add(sb.toString());
            if (elementsPerPartition > 0) {
                currentString.subList(0, elementsPerPartition).clear();
            }
//            for (int j = 0; j < elementsPerPartition; j++) {
//                currentString.remove(0);
//            }
        }
        sb.setLength(0);
        for (String s : currentString) {
            sb.append(s);
        }
//        for (int i = 0; i < currentString.size(); i++) {
//            sb.append(currentString.get(i));
//        }
        tempList.add(sb.toString());

        for (int i = 0; i < tempList.size(); i++) {

            if (i == 0) {
                input.set(index, tempList.get(i));
            } else {
                input.add(index + i, tempList.get(i));
            }

        }

    }
}