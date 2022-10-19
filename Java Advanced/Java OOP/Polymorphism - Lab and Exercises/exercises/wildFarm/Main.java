package exercises.wildFarm;

import exercises.wildFarm.Animal.*;
import exercises.wildFarm.food.Food;
import exercises.wildFarm.food.Meat;
import exercises.wildFarm.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Mammal> mammals = new ArrayList<>();

        String data;
        while (!(data = scanner.nextLine()).equals("End")) {


            Mammal mammal = createMammal(data);
            mammals.add(mammal);

            data = scanner.nextLine();

            Food food = collectFood(data);

            mammal.makeSound();

            try {
                mammal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        mammals.stream().map(Mammal::mammalInfo).forEach(System.out::println);
    }

    private static Food collectFood(String data) {

        String[] tokens = data.split("\\s+");

        Food food;

        String foodType = tokens[0];
        int foodQuantity = Integer.parseInt(tokens[1]);

        switch (foodType) {
            case "Meat":
                food = new Meat(foodQuantity);
                break;
            case "Vegetable":
                food = new Vegetable(foodQuantity);
                break;
            default:
                throw new IllegalArgumentException("no such food");
        }

        return food;
    }

    private static Mammal createMammal(String data) {

        String[] tokens = data.split("\\s+");

        Mammal mammal;

        String animalType = tokens[0];
        String animalName = tokens[1];


        switch (animalType) {


            case "Mouse":
                mammal = new Mouse(
                        animalType,
                        animalName,
                        Double.parseDouble(tokens[2]), tokens[3]);
                break;
            case "Cat":
                mammal = new Cat(animalType,
                        animalName,
                        Double.parseDouble(tokens[2]),
                        tokens[3], tokens[4]);
                break;
            case "Tiger":
                mammal = new Tiger(animalType,
                        animalName,
                        Double.parseDouble(tokens[2]),
                        tokens[3]);
                break;
            case "Zebra":
                mammal = new Zebra(animalType,
                        animalName,
                        Double.parseDouble(tokens[2]),
                        tokens[3]);
                break;
            default:
                throw new IllegalArgumentException("no such animal");
        }
        return mammal;
    }
}
