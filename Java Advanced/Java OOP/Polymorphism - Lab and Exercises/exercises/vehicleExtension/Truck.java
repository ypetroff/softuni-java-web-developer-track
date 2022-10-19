package exercises.vehicleExtension;

public class Truck extends Vehicle {

    private final double ADDITIONAL_CONSUMPTION = 1.6;
    private final double PRESERVE_LOSS = .95;

    public Truck(double fuelQuantity, double litersPerKilometer, double tankCapacity) {
        super(fuelQuantity, litersPerKilometer, tankCapacity);
    }

    @Override
    public void setLitersPerKilometer(double litersPerKilometer) {
        super.setLitersPerKilometer(litersPerKilometer + ADDITIONAL_CONSUMPTION);
    }

    public void refuel(double liters) {
        super.refuel(liters * PRESERVE_LOSS);
    }
}
