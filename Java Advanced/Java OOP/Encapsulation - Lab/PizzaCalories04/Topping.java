package PizzaCalories04;

public class Topping {

    private static final double BASE_CALORIES_PER_GRAM = 2;

    private String toppingType;
    private double weight;
    private double modifier = 1;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {

        switch (toppingType) {
            case "Meat":
                modifier *= 1.2;
                break;
            case "Veggies":
                modifier *= .8;
                break;
            case "Cheese":
                modifier *= 1.1;
                break;
            case "Sauce":
                modifier *= .9;
                break;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));

        }

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {

        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return BASE_CALORIES_PER_GRAM * weight * modifier;
    }
}
