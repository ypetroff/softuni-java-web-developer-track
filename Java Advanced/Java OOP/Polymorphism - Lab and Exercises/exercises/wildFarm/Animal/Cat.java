package exercises.wildFarm.Animal;

import exercises.wildFarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime{

    private final String catBreed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String catBreed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.catBreed = catBreed;
    }


    @Override
    public String toString() {
        return "Meowwww";
    }

    public String mammalInfo() {

        DecimalFormat df = new DecimalFormat("##.##");
        //"{AnimalType} [{AnimalName}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}
     return    String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(), super.getAnimalName(), this.catBreed, df.format(super.getAnimalWeight()), super.getLivingRegion(), super.getFoodEaten());
    }
}
