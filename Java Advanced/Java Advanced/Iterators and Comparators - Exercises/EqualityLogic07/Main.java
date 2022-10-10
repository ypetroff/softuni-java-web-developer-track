package EqualityLogic07;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> threeSet = new TreeSet<>(new CompareByHashCode());
        Set<Person> hashSet = new HashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
            threeSet.add(person);
            hashSet.add(person);
        }

        System.out.println(threeSet.size());
        System.out.println(hashSet.size());
    }
}
