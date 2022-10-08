package GenericCountMethodString05;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<String> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());
        IntStream.range(0, n).mapToObj(i -> scanner.nextLine()).forEach(box::add);
        String compareTo = scanner.nextLine();
        System.out.println(box.compareByValue(compareTo));

    }
}
