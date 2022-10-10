package PetClinics08;

public class Pet {
    private final String name;
    private final int age;
    private final String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.name, this.age, this.kind);
    }
}
