package PizzaCalories04;

public class Dough {

    private static final double BASE_CALORIES_PER_GRAM = 2;

    private String flourType;
    private String bakingTechnique;
    private double weight;
    private double modifier = 1;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {


        switch (flourType) {
            case "White":
                modifier *= 1.5;
                break;
            case "Wholegrain":
                modifier *= 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {

        switch (bakingTechnique) {
            case "Crispy":
                modifier *= .9;
                break;
            case "Chewy":
                modifier *= 1.1;
                break;
            case "Homemande":
                modifier *= 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {

        if (weight < 1 || weight > 200) {

            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    public double calculateCalories() {

        return BASE_CALORIES_PER_GRAM * weight * modifier;

    }
}
