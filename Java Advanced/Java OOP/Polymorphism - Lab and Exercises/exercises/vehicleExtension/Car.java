package exercises.vehicleExtension;

public class Car extends Vehicle {

    private final double ADDITIONAL_CONSUMPTION = .9;


    public Car(double fuelQuantity, double litersPerKilometer, double tankCapacity) {
        super(fuelQuantity, litersPerKilometer, tankCapacity);
    }

    @Override
    public void setLitersPerKilometer(double litersPerKilometer) {
        super.setLitersPerKilometer(litersPerKilometer + ADDITIONAL_CONSUMPTION);
    }
}
