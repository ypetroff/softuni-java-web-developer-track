package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut implements Astronaut{

    private final static double INITIAL_OXYGEN_UNITS = 70;
    private static final double DEFAULT_DECREASE_UNITS = 5;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN_UNITS);
        super.setOxygen(INITIAL_OXYGEN_UNITS);
    }

    @Override
    public void breath() {
        super.setOxygen(super.getOxygen() - DEFAULT_DECREASE_UNITS);
    }
}
