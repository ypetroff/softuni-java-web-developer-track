package CatLady09;

public class Cat {
    protected String breed;
    protected String name;

    public Cat(String breed, String name) {
        this.breed = breed;
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.breed, this.name);
    }
}






