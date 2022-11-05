package spaceStation.models.astronauts;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.CompletionService;

public abstract class BaseAstronaut implements Astronaut {

    private static final double DEFAULT_DECREASE_UNITS = 10;

    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        this.oxygen = Math.max(0, this.oxygen - DEFAULT_DECREASE_UNITS);
    }

    @Override
    public String toString() {

        List<String> temp = (List<String>) this.bag.getItems();

        String bagItems = temp.size() > 0
                ? String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, this.bag.getItems())
                : "none";



        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, this.name)).append(System.lineSeparator())
                .append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, this.oxygen)).append(System.lineSeparator())
                .append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, bagItems));


        return sb.toString().trim();
    }


}
