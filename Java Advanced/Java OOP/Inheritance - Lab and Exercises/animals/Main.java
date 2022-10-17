package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input;
        while (!(input = scanner.nextLine()).equals("Beast!")) {

            String[] animalInfo = scanner.nextLine().split("\\s+");

            try {

                switch (input) {

                    case "Dog":
                        Dog dog = new Dog(animalInfo[0], Integer.parseInt(animalInfo[1]), animalInfo[2]);
                        animals.add(dog);
                        break;
                    case "Frog":
                        Frog frog = new Frog(animalInfo[0], Integer.parseInt(animalInfo[1]), animalInfo[2]);
                        animals.add(frog);
                        break;
                    case "Cat":
                        Cat cat = new Cat(animalInfo[0], Integer.parseInt(animalInfo[1]), animalInfo[2]);
                        animals.add(cat);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(animalInfo[0], Integer.parseInt(animalInfo[1]));
                        animals.add(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(animalInfo[0], Integer.parseInt(animalInfo[1]));
                        animals.add(tomcat);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        animals.stream().map(Animal::toString).forEach(System.out::println);
    }
}
