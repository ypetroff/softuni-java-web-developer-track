package Threeuple11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Threeuple<String, String, String> threeuple1 = new Threeuple<>(String.format("%s %s", input[0], input[1]), input[2], input[3]);
        System.out.println(threeuple1);

        input = scanner.nextLine().split("\\s+");
        Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(input[0] , Integer.parseInt(input[1]), isDrunk(input[2]));
        System.out.println(threeuple2);

        input = scanner.nextLine().split("\\s+");
        Threeuple<String, Double, String> threeuple3 = new Threeuple<>(input[0] , Double.parseDouble(input[1]), input[2]);
        System.out.println(threeuple3);
    }

    private static Boolean isDrunk(String input) {
        return input.equals("drunk");
    }
}
