package exercises.vehicle;

public class Truck extends Vehicle{

    private final double ADDITIONAL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double litersPerKilometer) {
        super(fuelQuantity, litersPerKilometer);
    }

    @Override
    public String drive(double kilometers) {
        double necessaryFuel = (ADDITIONAL_CONSUMPTION + super.getLitersPerKilometer()) * kilometers;

        if(necessaryFuel > super.getFuelQuantity()) {
            return super.notEnoughFuel();
        } else {

            decreaseFuelQuantity(necessaryFuel);

            return travelledDistance(kilometers);
        }
    }

    @Override
    public void refuel(double fuel) {
        super.setFuelQuantity((super.getFuelQuantity() + fuel * .95));
    }
}
