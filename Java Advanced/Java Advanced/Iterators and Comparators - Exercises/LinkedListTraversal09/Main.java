package LinkedListTraversal09;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Integer> linkedList = new LinkedList<>(new ArrayList<>());

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "Add":
                    linkedList.add(Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    linkedList.remove(Integer.parseInt(command[1]));
                    break;
            }
        }

        System.out.println(linkedList.getSize());
        for (Integer integer : linkedList) {
            System.out.print(integer + " ");
        }
    }
}
