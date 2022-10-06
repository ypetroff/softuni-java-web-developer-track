package CatLady09;

public class Siamese extends Cat{

    private final double earSize;

    public Siamese(String breed, String name, double earSize) {
        super(breed, name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getBreed(), getName(), this.earSize);
    }
}
