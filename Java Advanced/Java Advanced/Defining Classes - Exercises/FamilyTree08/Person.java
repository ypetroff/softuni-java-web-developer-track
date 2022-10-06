package FamilyTree08;

public class Person {
    private  String name;
    private final String birthDate;


    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

}
