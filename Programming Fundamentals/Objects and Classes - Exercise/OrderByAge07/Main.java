package OrderByAge07;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String personalInfo = scanner.nextLine();
        List<Person> people = new ArrayList<>();

        while (!personalInfo.equalsIgnoreCase("end")) {
            String[] data = personalInfo.split(" ");
             String name = data[0];
             String ID = data[1];
             int age = Integer.parseInt(data[2]);

             Person person = new Person(name, ID, age);
             people.add(person);

            personalInfo = scanner.nextLine();
        }

        people.stream().sorted(Comparator.comparing(Person::getAge)).forEach(p -> System.out.println(p.printList()));
       // people.stream().filter(Objects::nonNull).sorted()....
    }
}
