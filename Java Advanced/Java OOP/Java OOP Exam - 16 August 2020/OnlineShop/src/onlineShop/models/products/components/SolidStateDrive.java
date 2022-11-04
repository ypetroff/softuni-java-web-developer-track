package onlineShop.models.products.components;

public class SolidStateDrive extends BaseComponent implements Component {

    private final static double MULTIPLIER = 1.2;

    public SolidStateDrive(
            int id, String manufacturer, String model, double price, double overallPerformance, int generation) {

        super(id, manufacturer, model, price, overallPerformance * MULTIPLIER, generation);

    }
}
