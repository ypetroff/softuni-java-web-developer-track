package fairyShop.models;

import fairyShop.common.ExceptionMessages;
import fairyShop.common.Validations;

public class PresentImpl implements Present{

    private final static int DEFAULT_DECREASE_UNITS = 10;

    private String name;
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
        this.setName(name);
        this.setEnergyRequired(energyRequired);
    }

    public void setName(String name) {
        Validations.validateNullOrEmpty(name, ExceptionMessages.PRESENT_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    public void setEnergyRequired(int energyRequired) {
        Validations.validateNumberIsBelowZero(energyRequired, ExceptionMessages.PRESENT_ENERGY_LESS_THAN_ZERO);
        this.energyRequired = energyRequired;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergyRequired() {
        return this.energyRequired;
    }

    @Override
    public boolean isDone() {
        return this.energyRequired == 0;
    }

    @Override
    public void getCrafted() {
        this.energyRequired = Math.max(0, this.energyRequired - DEFAULT_DECREASE_UNITS);
    }
}
