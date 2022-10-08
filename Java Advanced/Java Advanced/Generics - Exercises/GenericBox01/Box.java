package GenericBox01;

public class Box<T> {

    private final T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", value.getClass().getName(), value);
    }
}
