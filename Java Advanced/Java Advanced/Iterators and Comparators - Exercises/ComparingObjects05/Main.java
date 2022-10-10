package ComparingObjects05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String data;
        while (!(data = scanner.nextLine()).equals("END")) {
            String[] personInfo = data.split("\\s+");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]), personInfo[2]);
            people.add(person);
        }

        int match = Integer.parseInt(scanner.nextLine());

        Person requesterPerson = people.get(match - 1);
        long equalPeople = people.stream().filter(p -> p.compareTo(requesterPerson) == 0).count();

        if(equalPeople == 1) {
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d", equalPeople, people.size() - equalPeople, people.size());
        }
    }
}
