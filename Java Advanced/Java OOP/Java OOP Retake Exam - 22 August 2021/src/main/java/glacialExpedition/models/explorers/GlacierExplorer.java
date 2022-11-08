package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer{

    private final static double DEFAULT_INITIAL_ENERGY_UNITS = 40;

    public GlacierExplorer(String name) {
        super(name, DEFAULT_INITIAL_ENERGY_UNITS);
    }
}
