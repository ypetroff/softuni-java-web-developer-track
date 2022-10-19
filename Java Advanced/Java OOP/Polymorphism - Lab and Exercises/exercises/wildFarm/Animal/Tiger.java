package exercises.wildFarm.Animal;

import exercises.wildFarm.food.Food;

public class Tiger extends Felime{

    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {

        if(food.getClass().getSimpleName().equals("Meat")) {
            super.eat(food);
        } else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        return "ROAAR!!!";
    }
}
