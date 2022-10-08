package Tuple10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Tuple<String, String> tuple1 = new Tuple<>(input[0] + " " + input[1], input[2]);
        System.out.println(tuple1);

        input = scanner.nextLine().split("\\s+");
        Tuple<String, Integer> tuple2 = new Tuple<>(input[0], Integer.parseInt(input[1]));
        System.out.println(tuple2);

        input = scanner.nextLine().split("\\s+");
        Tuple<Integer, Double> tuple3 = new Tuple<>(Integer.parseInt(input[0]), Double.parseDouble(input[1]));
        System.out.println(tuple3);

    }
}
