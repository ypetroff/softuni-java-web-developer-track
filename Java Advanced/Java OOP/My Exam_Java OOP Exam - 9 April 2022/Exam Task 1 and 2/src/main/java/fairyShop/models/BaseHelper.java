package fairyShop.models;

import fairyShop.common.ExceptionMessages;
import fairyShop.common.Validations;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHelper implements Helper{

    private final static int DEFAULT_DECREASE_UNITS = 10;

    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    protected BaseHelper(String name, int energy) {
       this.setName(name);
       this.setEnergy(energy);
       instruments = new ArrayList<>();

    }

    private void setName(String name) {
        Validations.validateNullOrEmpty(name, ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public void work() {
       this.setEnergy(Math.max(0, this.energy - DEFAULT_DECREASE_UNITS));
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return this.instruments;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%n" +
                "Energy: %d%n" +
                "Instruments: %d not broken left",this.name, this.energy, notBrokenInstruments());

    }

    protected long notBrokenInstruments() {
       return instruments.stream().filter(i -> !i.isBroken()).count();
    }
}
