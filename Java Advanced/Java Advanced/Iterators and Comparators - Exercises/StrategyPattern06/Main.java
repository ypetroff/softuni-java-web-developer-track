package StrategyPattern06;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> peopleOrderedByName = new TreeSet<>(new CompareByName());
        Set<Person> peopleOrderedByAge = new TreeSet<>(new CompareByAge());

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            Person person = new Person(personInfo[0],Integer.parseInt(personInfo[1]));
            peopleOrderedByName.add(person);
            peopleOrderedByAge.add(person);
        }
        peopleOrderedByName.forEach(System.out::println);
        peopleOrderedByAge.forEach(System.out::println);
    }
}
