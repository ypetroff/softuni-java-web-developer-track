package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut implements Astronaut{

    private final static double INITIAL_OXYGEN_UNITS = 50;


    public Geodesist(String name) {
        super(name, INITIAL_OXYGEN_UNITS);
    }
}
