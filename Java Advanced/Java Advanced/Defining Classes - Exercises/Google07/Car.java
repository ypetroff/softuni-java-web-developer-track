package Google07;

public class Car {
    private final String name;
    private final String speed;

    public Car(String name, String speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.name, this.speed);
    }
}
