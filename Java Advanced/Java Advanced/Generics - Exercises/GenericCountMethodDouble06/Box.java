package GenericCountMethodDouble06;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable<T>>{

    private final List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T value) {
        this.values.add(value);
    }

    public long compareByValue(T value) {
        return this.values.stream().filter(x -> x.compareTo(value) > 0).count();
    }
}
