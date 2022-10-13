package StudentSystem03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String command;
        while (!(command = scanner.nextLine()).equals("Exit"))
        {
            String[] input = command.split(" ");

            studentSystem.parseCommand(input);
        }
    }
}
