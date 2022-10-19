package exercises.wildFarm.Animal;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{

    private String livingRegion;

    public Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String mammalInfo() {

        DecimalFormat df = new DecimalFormat("##.##");
        //"{AnimalType} [{AnimalName}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}
      return   String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(), super.getAnimalName(), df.format(super.getAnimalWeight()), this.getLivingRegion(), super.getFoodEaten());
    }

    public String getLivingRegion() {
        return livingRegion;
    }
}
