package fairyShop.models;

public class Sleepy extends BaseHelper {

    private final static int INITIAL_ENERGY_UNITS = 50;
    private final static int DEFAULT_DECREASE_UNITS = 5;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY_UNITS);
    }

    @Override
    public void work() {
        this.setEnergy(Math.max(0, super.getEnergy() - DEFAULT_DECREASE_UNITS));
    }
}
