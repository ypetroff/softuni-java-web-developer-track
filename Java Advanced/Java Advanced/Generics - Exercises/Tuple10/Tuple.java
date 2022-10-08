package Tuple10;

public class Tuple <T, E>{
    private final T item1;
    private final E item2;

    public Tuple(T item1, E item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.item1, this.item2);
    }
}
