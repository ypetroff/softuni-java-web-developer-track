package glacialExpedition.models.explorers;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.common.Validations;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer{

    private final static int DEFAULT_DECREASING_UNITS = 15;

    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        suitcase = new Carton();
    }

    public void setName(String name) {
        Validations.nullOrEmpty(name, ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    public void setEnergy(double energy) {
        Validations.negativeNumber(energy, ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return this.energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        this.energy = Math.max(0, this.energy - DEFAULT_DECREASING_UNITS);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(System.lineSeparator());
        sb.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, this.name));
        sb.append(System.lineSeparator());
        sb.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, this.energy));
        sb.append(System.lineSeparator());
        sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,suitcaseElementsToString()));

        return sb.toString();
    }

    protected String suitcaseElementsToString() {

        return this.suitcase.getExhibits().size() == 0
                ? "None"
                : String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, this.suitcase.getExhibits());
    }

}
