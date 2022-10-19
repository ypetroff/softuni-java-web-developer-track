package exercises.vehicleExtension;

import java.text.DecimalFormat;

public class Vehicle {

    private double fuelQuantity;
    private double litersPerKilometer;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double litersPerKilometer, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        setLitersPerKilometer(litersPerKilometer);
        this.tankCapacity = tankCapacity;
    }

    public String drive(double kilometers) {

        double neededFuel = this.litersPerKilometer * kilometers;

        if (neededFuel > this.fuelQuantity) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        this.fuelQuantity -= neededFuel;

        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(kilometers));
    }

    public void refuel(double liters) {
        if(liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if(liters + this.fuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    public void setLitersPerKilometer(double litersPerKilometer) {
        this.litersPerKilometer = litersPerKilometer;
    }
}
