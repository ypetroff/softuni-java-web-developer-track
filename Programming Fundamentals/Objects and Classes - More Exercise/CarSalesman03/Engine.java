package CarSalesman03;

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public String getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public String toString() {
        return String.format("%s:%n" +
                "Power: %s%n" +
                "Displacement: %s%n" +
                "Efficiency: %s", getModel(), getPower(), getDisplacement(), getEfficiency());
    }
}
