package aquarium.entities.decorations;

public class Plant extends BaseDecoration {


    private static final int COMFORT_CONST = 5;
    private static final double PRICE_CONST = 10;

    public Plant() {
        super(COMFORT_CONST, PRICE_CONST);
    }
}
