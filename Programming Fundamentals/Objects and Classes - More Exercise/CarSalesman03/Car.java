package CarSalesman03;

 class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String colour;

    public Car(String model, Engine engine, String weight, String colour) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.colour = colour;
    }

     public String getModel() {
         return model;
     }

     public Engine getEngine() {
         return engine;
     }

     public String getWeight() {
         return weight;
     }

     public String getColour() {
         return colour;
     }

     public String toString() {
        Engine engine = this.getEngine();
        return String.format("%s:%n" +
                "%s%n" +
                "Weight: %s%n" +
                "Color: %s", getModel(),engine.toString(), getWeight(), getColour());
     }
 }


