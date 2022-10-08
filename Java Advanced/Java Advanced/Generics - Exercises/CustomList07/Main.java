package CustomList07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String command;
        while (!(command = scanner.nextLine()).equals("END")) {
            String[] instructions = command.split("\\s+");

            switch (instructions[0]) {
                case "Add":
                    customList.add(instructions[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(instructions[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(instructions[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(instructions[1]), Integer.parseInt(instructions[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(instructions[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.print();
                    break;
            }
        }
    }
}
