package exercises.wildFarm.Animal;

import exercises.wildFarm.food.Food;

public abstract class Animal {

   private String animalType;
    private String animalName;
    private Double animalWeight;
   private Integer foodEaten;

    public Animal(String animalType , String animalName, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public void makeSound(){
        System.out.println(this);
    }

    public  void eat(Food food) {
        foodEaten+= food.getQuantity();
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }
}
