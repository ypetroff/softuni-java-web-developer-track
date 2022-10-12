package June20.parking;

public class Car {

    private String manufacturer;
    private String model;
    private int year;

    public Car(String manufacturer, String model, int age) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = age;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", this.manufacturer, this.model, this.year);
    }
}
