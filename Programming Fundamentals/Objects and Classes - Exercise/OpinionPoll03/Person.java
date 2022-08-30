package OpinionPoll03;

public class Person {
    private String name;
    private int age;

    public Person () {

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String printPeopleOver30() {
        //System.out.printf("%s - %d%n", this.name, this.age);
        String result = this.name + " - " +this.age;
        return result;
    }
}
