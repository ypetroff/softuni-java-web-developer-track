package exercises.vehicle;

public class Car extends Vehicle{

    private final double ADDITIONAL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double litersPerKilometer) {
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
        super.setFuelQuantity((super.getFuelQuantity() + fuel));
    }
}
