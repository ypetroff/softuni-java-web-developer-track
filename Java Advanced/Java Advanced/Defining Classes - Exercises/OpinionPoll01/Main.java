package OpinionPoll01;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        Set<Person> people = new HashSet<>();
        while (numberOfPeople-- > 0) {
            String[] nameAndAge = scanner.nextLine().split("\\s+");
            Person person = new Person(nameAndAge[0],Integer.parseInt(nameAndAge[1]));
            people.add(person);
        }
        Predicate<Person> ageFilter = x -> x.getAge() > 30;
        Comparator<Person> orderNames = Comparator.comparing(Person::getName);
        Consumer<Person> print = p -> System.out.printf("%s - %d%n", p.getName(), p.getAge());
       people.stream().filter(ageFilter).sorted(orderNames).forEach(print);

    }
}
