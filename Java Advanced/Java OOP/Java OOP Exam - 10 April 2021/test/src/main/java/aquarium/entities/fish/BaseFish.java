package aquarium.entities.fish;

import aquarium.common.ExceptionMessages;
import aquarium.common.Validations;

public abstract class BaseFish implements Fish {

    private static final int DEFAULT_INCREMENT = 5;

    private String name;
    private String species;
    private int size;
    private double price;

    public BaseFish(String name, String species, double price) {
        this.setName(name);
        this.setSpecies(species);
        this.setPrice(price);
        this.setSize(0); //todo: what is the default size?
    }

    @Override
    public void setName(String name) {
        Validations.validateNotNullOrEmptyString(name, ExceptionMessages.FISH_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    @Override //TODO: some fish can implement the method in a different way
    public void eat() {
        this.size += DEFAULT_INCREMENT;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.FISH_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }

    public void setSpecies(String species) {
        Validations.validateNotNullOrEmptyString(species, ExceptionMessages.SPECIES_NAME_NULL_OR_EMPTY);
        this.species = species;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
