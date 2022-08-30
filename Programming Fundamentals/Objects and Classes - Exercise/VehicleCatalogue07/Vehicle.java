package VehicleCatalogue07;

import java.util.Locale;

public class Vehicle {
    private String type;
    private String model;
    private String colour;
    private int horsePower;

    public Vehicle(String type, String model, String colour, int horsePower) {
        this.type = type;
        this.model = model;
        this.colour = colour;
        this.horsePower = horsePower;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public int getHorsePower() {
        return horsePower;
    }

    String printVehicle() {
      //  String typeFirstCapital = this.type.substring(0, 1). toUpperCase(Locale.ROOT) + this.type.substring(1);
        return String.format("Type: %s%n" +
                "Model: %s%n" +
                "Color: %s%n" +
                "Horsepower: %d", capitalise(this.type), this.model, this.colour, this.horsePower);
    }
    public static String capitalise(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
