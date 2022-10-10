package Froggy04;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> poolOfNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String end = scanner.nextLine();

        Lake lake = new Lake(poolOfNumbers);
        Iterator<Integer> iterator = lake.iterator();

        while (iterator.hasNext()) {
            String current = iterator.next().toString();
            System.out.print(iterator.hasNext() ? String.format("%s, ", current) : current);
        }
    }
}
