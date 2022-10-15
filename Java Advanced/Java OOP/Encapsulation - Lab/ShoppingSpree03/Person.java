package ShoppingSpree03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private final List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {

        isEmptyString(name);
        this.name = name;
    }

    private void setMoney(double money) {

        isNotNegative(money);
        this.money = money;

    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }


    static void isNotNegative(double amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

    }

     static void isEmptyString(String name) {

        if ( name == null || name.trim().isEmpty()) { //note: I missed validating properly if the string is null or empty
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public void buyProduct(Product product) {

        if(this.money < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }

        this.money-= product.getCost();
        products.add(product);
        System.out.printf("%s bought %s%n", this.name, product.getName());
    }

    @Override
    public String toString() {

        if(products.size() < 1) {
            return String.format("%s - Nothing bought", this.name);
        }

        return String.format("%s - %s", this.name, listProducts(products));
    }

    private String listProducts(List<Product> products) {
        return products.stream().map(Product::getName).collect(Collectors.joining(", "));
    }
}
