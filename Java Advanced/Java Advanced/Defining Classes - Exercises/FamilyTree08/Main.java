package FamilyTree08;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String personalQueue = scanner.nextLine();

        List<Parent> parents = new ArrayList<>();
        List<Child> children = new ArrayList<>();
        List<Person> people = new ArrayList<>();

        String command;
        while (!(command = scanner.nextLine()).equals("End")) {
            if (command.contains(" - ")) {

                createParentAndChild(command, parents, children);

            } else {

                createPerson(people, command);

            }
        }
        String name;
        String birthDate;
        if(personalQueue.contains("/")) {
            name =  people.stream().filter(p -> p.getBirthDate().equals(personalQueue))
                    .map(Person::getName).findFirst().orElseThrow();
            birthDate = personalQueue;
        }else {
            name = personalQueue;
            birthDate = people.stream().filter(p -> p.getName().equals(name))
                    .map(Person::getBirthDate).findFirst().orElseThrow();
        }

     List<String> parentsIdentifiers = new ArrayList<>();
             parents.stream().filter(i -> i.getIdentifier().equals(name) || i.getIdentifier().equals(birthDate))
                .map(Parent::getChildren).forEach(parentsIdentifiers::addAll);

        List<String> childrenIdentifiers = new ArrayList<>();
        children.stream().filter(i -> i.getIdentifier().equals(name) || i.getIdentifier().equals(birthDate))
                .map(Child::getParents).forEach(childrenIdentifiers::addAll);

        List<Person> childrenOfTheRequestedPerson = new ArrayList<>();
        if(parentsIdentifiers.size() > 0) {
            parentsIdentifiers.forEach(x -> people.stream().filter(p -> p.getName().equals(x) || p.getBirthDate().equals(x))
                    .forEach(childrenOfTheRequestedPerson::add));
        }
        List<Person> parentsOfTheRequestedPerson = new ArrayList<>();
        if(childrenIdentifiers.size() > 0) {
            childrenIdentifiers.forEach(x -> people.stream().filter(p -> p.getName().equals(x) || p.getBirthDate().equals(x))
                    .forEach(parentsOfTheRequestedPerson::add));
        }

        System.out.println(name + " " + birthDate);
        System.out.println("Parents:");
        parentsOfTheRequestedPerson.forEach(x -> System.out.printf("%s %s%n", x.getName(), x.getBirthDate()));
        System.out.println("Children:");
        childrenOfTheRequestedPerson.forEach(x -> System.out.printf("%s %s%n", x.getName(), x.getBirthDate()));
    }

    private static void createParentAndChild(String command, List<Parent> parents, List<Child> children) {
        String[] peopleData = command.split(" - ");
        Parent parent = new Parent(peopleData[0], new ArrayList<>());
        parent.getChildren().add(peopleData[1]);
        Child child = new Child(peopleData[1], new ArrayList<>());
        child.getParents().add(peopleData[0]);
        parents.add(parent);
        children.add(child);
    }

    private static void createPerson(List<Person> people, String command) {
        String[] personData = command.split("\\s+");
        String name = personData[0] + " " + personData[1];
        String birthdate = personData[2];
        Person person = new Person(name, birthdate);
        people.add(person);
    }
}
