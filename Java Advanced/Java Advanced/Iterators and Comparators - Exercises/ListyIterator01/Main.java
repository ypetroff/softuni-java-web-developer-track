package ListyIterator01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1).collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(list);
        String command;
        while (!(command = scanner.nextLine()).equals("END")) {

            switch (command) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    }catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
