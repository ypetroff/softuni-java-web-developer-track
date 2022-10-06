package RawData04;

import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }

    public boolean checkTires (List<Tire> tires) {
        List<Tire> collect = tires.stream().filter(tire -> tire.getPressure() < 1).collect(Collectors.toList());
        return collect.size() > 0;
    }

    public boolean checkEngine (Engine engine) {
        return engine.getPower() > 250;
    }
}


