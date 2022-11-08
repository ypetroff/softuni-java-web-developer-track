package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{

    private final static double DEFAULT_INITIAL_ENERGY_UNITS = 60;
    private final static int DEFAULT_DECREASING_UNITS = 7;

    public NaturalExplorer(String name) {
        super(name, DEFAULT_INITIAL_ENERGY_UNITS);
    }

    @Override
    public void search() {
        this.setEnergy(Math.max(0, this.getEnergy() - DEFAULT_DECREASING_UNITS));
    }
}
