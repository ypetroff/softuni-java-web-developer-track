package exercises.vehicle;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private final double litersPerKilometer;

    public Vehicle(double fuelQuantity, double litersPerKilometer) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKilometer = litersPerKilometer;
    }

    public abstract String drive(double kilometers);

    public abstract void refuel(double fuel);

    public String notEnoughFuel() {
        return String.format("%s needs refueling",this.getClass().getSimpleName());
    }

    public void decreaseFuelQuantity(double spentFuel) {
        this.fuelQuantity-=spentFuel;
    }

    public String travelledDistance (double kilometers) {

        DecimalFormat df = new DecimalFormat("#.##");

        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(kilometers));
    }

    public String fuelTank() {
        DecimalFormat df = new DecimalFormat("#.00");
        return String.format("%s: %s",this.getClass().getSimpleName(), df.format(this.fuelQuantity));
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getLitersPerKilometer() {
        return litersPerKilometer;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }
}
