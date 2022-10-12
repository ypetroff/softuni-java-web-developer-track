package Feb21.dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {

    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {

        if(capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) { //!!!
        return data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream().max(Comparator.comparingInt(Car::getYear)) //min
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return  this.data.stream()
                .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return String.format("The cars are in a car Feb21.dealership %s:%n%s",
                this.name, this.data.stream().map(Car::toString).collect(Collectors.joining(System.lineSeparator())));
    }
}
