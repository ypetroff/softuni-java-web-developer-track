package GenericCountMethodDouble06;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Double> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());
        IntStream.range(0, n).mapToDouble(i -> Double.parseDouble(scanner.nextLine())).forEach(box::add);
        Double compareTo = Double.parseDouble(scanner.nextLine());
        System.out.println(box.compareByValue(compareTo));

    }
}
