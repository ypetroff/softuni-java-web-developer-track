package OrderByAge07;

public class Person {
    private String name;
    private String ID;
    private int age;

    public Person(String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String printList() {
        return String.format("%s with ID: %s is %d years old.", this.name, this.ID, this.age);
    }
}
