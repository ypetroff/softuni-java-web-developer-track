package OpinionPoll03;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesOfPersonalInfo = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < linesOfPersonalInfo; i++) {
            String[] personalInfo = scanner.nextLine().split(" ");
            String name = personalInfo[0];
            int age = Integer.parseInt(personalInfo[1]);

            Person person = new Person();
            person.setName(name);
            person.setAge(age);
            people.add(person);
        }

        List <Person> result = people.stream()
                .filter(p -> p.getAge() > 30).sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());

        result.forEach(p -> System.out.println(p.printPeopleOver30()));

        // or people.stream()
        //                .filter(p -> p.getAge() > 30).sorted(Comparator.comparing(Person::getName))
        //                .forEach(p -> System.out.println(p.printPeopleOver30()));


    }


}
