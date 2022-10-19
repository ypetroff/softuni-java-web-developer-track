package exercises.vehicleExtension;

public class Bus extends Vehicle{

    private final double ADDITIONAL_CONSUMPTION = 1.4;

    private boolean isEmpty;

    public Bus(double fuelQuantity, double litersPerKilometer, double tankCapacity) {
        super(fuelQuantity, litersPerKilometer, tankCapacity);
        isEmpty = false;
    }

    @Override
    public void setLitersPerKilometer(double litersPerKilometer) {

        if(!isEmpty) {
            super.setLitersPerKilometer(litersPerKilometer + ADDITIONAL_CONSUMPTION);
        } else {
            super.setLitersPerKilometer(litersPerKilometer);
        }



    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
