package CarSalesman05;

public class Car {
   private final String model;
   private final Engine engine;
   private final String weight; //opt
   private final String colour; //opt

    public Car(String model, Engine engine, String weight, String colour) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.colour = colour;
    }

    @Override
    public String toString() {

        return String.format("%s:%n" +
                "%s:%n" +
                "Power: %s%n" +
                "Displacement: %s%n" +
                        "Efficiency: %s%n" +
                        "Weight: %s%n" +
                        "Color: %s%n",this.model, this.engine.getModel(),
                this.engine.getPower(), this.engine.getDisplacement(), this.engine.getEfficiency(), this.weight, this.colour);
    }
}
