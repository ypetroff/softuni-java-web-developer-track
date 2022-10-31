package restaurant.entities.drinks;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;

public abstract class BaseBeverage implements Beverages {

    private String name;
    private int counter;
    private double price;
    private String brand;

    public BaseBeverage(String name, int counter, double price, String brand) {
      this.setName(name);
      this.setCounter(counter);
      this.setPrice(price);
      this.setBrand(brand);
    }

    public void setName(String name) {
        validateNotNullOrEmpty(name, ExceptionMessages.INVALID_NAME);
        this.name = name;
    }

    public void setCounter(int counter) {
        validateNumberIsGreaterThanZero(counter, ExceptionMessages.INVALID_COUNTER);
        this.counter = counter;
    }

    public void setPrice(double price) {
        validateNumberIsGreaterThanZero(price, ExceptionMessages.INVALID_PRICE);
        this.price = price;
    }

    public void setBrand(String brand) {
        validateNotNullOrEmpty(brand, ExceptionMessages.INVALID_BRAND);
        this.brand = brand;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCounter() {
        return this.counter;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    private void validateNotNullOrEmpty(String str, String exceptionMessage) {
        if(str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private void validateNumberIsGreaterThanZero(double number, String exceptionMessage) {
        if(number <= 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
