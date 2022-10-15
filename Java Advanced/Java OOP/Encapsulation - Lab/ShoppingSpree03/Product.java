package ShoppingSpree03;

public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {

        Person.isEmptyString(name);
        this.name = name;
    }

    private void setCost(double cost) {
        Person.isNotNegative(cost);
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
