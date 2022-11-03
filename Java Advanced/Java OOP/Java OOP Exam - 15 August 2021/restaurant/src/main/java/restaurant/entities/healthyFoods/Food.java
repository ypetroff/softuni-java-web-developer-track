package restaurant.entities.healthyFoods;

import restaurant.common.ExceptionMessages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

public abstract class Food implements HealthyFood {

    private String name;
    private double portion;
    private double price;

    public Food(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }

        this.name = name;
    }

    public void setPortion(double portion) {
        validateIfNumberIsNegativeOrZero(portion, ExceptionMessages.INVALID_PORTION);

        this.portion = portion;
    }

    public void setPrice(double price) {
        validateIfNumberIsNegativeOrZero(price, ExceptionMessages.INVALID_PRICE);
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void validateIfNumberIsNegativeOrZero(double number, String exceptionMessage) {
        if(number <= 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
