package ComparingObjects05;

public class Person implements Comparable<Person> {
    private final String name;
    private int age;
    private final String city;

    public Person(String name, int age, String city) {
        this.name = name;
        setAge(age);
        this.city = city;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Enter a positive integer");
        } else {
            this.age = age;
        }
    }

    @Override
    public int compareTo(Person o) {
        int result = this.name.compareTo(o.name);
        if (result == 0) {
            result = Integer.compare(this.age, o.age);
        }
        if (result == 0) {
            result = this.city.compareTo(o.city);
        }
        return result;
    }
}
