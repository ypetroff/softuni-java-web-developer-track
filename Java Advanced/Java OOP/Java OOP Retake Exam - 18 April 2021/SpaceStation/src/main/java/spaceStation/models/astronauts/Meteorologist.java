package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut implements Astronaut{

    private final static double INITIAL_OXYGEN_UNITS = 90;

    public Meteorologist(String name) {
        super(name, INITIAL_OXYGEN_UNITS);
    }
}
