package RawData02;


import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire1;
    private Tire tire2;
    private Tire tire3;
    private Tire tire4;

    public Car(String model, Engine engine, Cargo cargo, Tire tire1, Tire tire2, Tire tire3, Tire tire4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire1 = tire1;
        this.tire2 = tire2;
        this.tire3 = tire3;
        this.tire4 = tire4;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire getTire1() {
        return tire1;
    }

    public Tire getTire2() {
        return tire2;
    }

    public Tire getTire3() {
        return tire3;
    }

    public Tire getTire4() {
        return tire4;
    }

    public static class Engine {
        private int speed;
        private int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }
    public static class Cargo {
        private int weight;
        private String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static class Tire {
        private int age;
        private double pressure;
        private List<Tire> tires = new ArrayList<>();


        public Tire(int age, double pressure) {
            this.age = age;
            this.pressure = pressure;
        }

        public double getPressure() {
            return pressure;
        }
    }

}

