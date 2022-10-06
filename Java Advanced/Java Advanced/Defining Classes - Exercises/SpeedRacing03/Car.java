package SpeedRacing03;

public class Car {

    private  String model;
    private double fuelAmount;
    private double fuelAmountPerKm;
    private int distance;

    public Car(String model, double fuelAmount, double fuelAmountPerKm, int distance) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelAmountPerKm = fuelAmountPerKm;
        this.distance = distance;
    }


    public void drive(int distance) {
        double neededFuel = fuelAmountPerKm * distance;
        if(neededFuel > this.fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            this.fuelAmount -=neededFuel;
            this.distance +=distance;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }
}
