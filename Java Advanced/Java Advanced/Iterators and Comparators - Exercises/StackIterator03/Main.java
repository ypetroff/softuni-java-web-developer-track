package StackIterator03;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        String command;
        while (!(command = scanner.nextLine()).equals("END")) {
            if (command.contains("Pop")) {
                try {
                    stack.pop();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }

            } else {
                Arrays.stream(command.replace("Push ", "").replaceAll(" ", "")
                                .split(","))
                        .mapToInt(Integer::parseInt).forEach(stack::push);
            }
        }

        IntStream.range(0, 2).forEach(i -> stack.forEach(System.out::println));
           ;

    }
}
