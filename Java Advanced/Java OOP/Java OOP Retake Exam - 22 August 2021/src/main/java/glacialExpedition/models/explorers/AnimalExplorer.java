package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer{

    private final static double DEFAULT_INITIAL_ENERGY_UNITS = 100;

    public AnimalExplorer(String name) {
        super(name, DEFAULT_INITIAL_ENERGY_UNITS);
    }
}
