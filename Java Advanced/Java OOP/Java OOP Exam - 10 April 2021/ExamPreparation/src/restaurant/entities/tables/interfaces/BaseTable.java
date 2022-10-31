package restaurant.entities.tables.interfaces;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseTable implements Table { //todo implement logic for all methods

    private Map<String, HealthyFood> healthyFood;
    /**
     * may be unmodifiable collection
     **/
    private Map<String, Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.setNumber(number);
        this.setSize(size);
        this.setPricePerPerson(pricePerPerson);
        this.healthyFood = new LinkedHashMap<>();
        this.beverages = new LinkedHashMap<>();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSize(int size) {
        validateNumberIsGreaterThanZero(size, ExceptionMessages.INVALID_TABLE_SIZE);
        this.size = size;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        validateNumberIsGreaterThanZero(numberOfPeople, ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        this.numberOfPeople = numberOfPeople;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
      setNumberOfPeople(numberOfPeople);
      isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.put(food.getName(), food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.put(beverages.getName(), beverages);
    }

    @Override
    public double bill() {
        return this.healthyFood.values().stream().mapToDouble(HealthyFood::getPrice).sum() +
                this.beverages.values().stream().mapToDouble(Beverages::getPrice).sum();
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.isReservedTable = false;
        this.numberOfPeople = 0;
        this.pricePerPerson = 0;
    }

    @Override
    public String tableInformation() { //todo fix price per person
        return String.format("Table - %d%n" +
                "Size - %d%n" +
                "Type - %s%n" +
                "All price -%.2f", this.number, this.size, this.getClass().getSimpleName(), pricePerPerson() * this.numberOfPeople);
    }

    protected void validateNumberIsGreaterThanZero(int number, String exceptionMessage) {
        if (number <= 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
