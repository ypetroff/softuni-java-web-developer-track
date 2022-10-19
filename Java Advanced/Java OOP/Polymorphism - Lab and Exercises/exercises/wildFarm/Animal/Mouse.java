package exercises.wildFarm.Animal;

import exercises.wildFarm.food.Food;

public class Mouse extends Mammal{

    public Mouse(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }


    @Override
    public void eat(Food food) {

        if(food.getClass().getSimpleName().equals("Vegetable")) {
            super.eat(food);
        } else {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }

    }

    @Override
    public String toString() {
        return "SQUEEEAAAK!";
    }
}
