package GenericSwapMethodInteger04;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private final List<T> value;

    public Box() {
        this.value = new ArrayList<>();
    }

    public void add(T val) {
        this.value.add(val);
    }

    public void swap(int index1, int index2) {
        T temp = this.value.get(index1);
        this.value.set(index1, this.value.get(index2));
        this.value.set(index2, temp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.value.forEach(value -> sb.append(String.format("%s: %s", value.getClass().getName(), value)).append(System.lineSeparator()));
        return sb.toString();
    }
}
