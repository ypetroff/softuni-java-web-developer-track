package Oct21.hotel;

public class Person {

    private final String name;
    private final int id;
    private final int age;
    private String hometown;

    public Person (String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = "n/a";
    }

    public Person(String name, int id, int age, String hometown) {
        this(name, id, age);
        this.hometown = hometown;
    }

    public String getName() {
        return name;
    }

    public String getHometown() {
        return hometown;
    }

    @Override
    public String toString() {
        return String.format("Person %s: %d, Age: %d, Hometown: %s", this.name, this.id, this.age, this.hometown);
    }
}
