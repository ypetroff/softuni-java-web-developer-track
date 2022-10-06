package CatLady09;

public class Cymric extends Cat{
    private final double furLength;

    public Cymric(String breed, String name, double furLength) {
        super(breed, name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",getBreed(), getName(), this.furLength);
    }
}
