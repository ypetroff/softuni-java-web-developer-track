package FirstAndReserveTeam04;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;


    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {

        lengthValidation(firstName, "First");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        lengthValidation(lastName, "Last");
        this.lastName = lastName;
    }

    private void lengthValidation(String name, String firstOrLast) {
        if (name.length() < 3) {
            String message = String.format("%s name cannot be less than 3 symbols", firstOrLast);
            throw new IllegalArgumentException(message);
        }
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void increaseSalary(double incrementPercentage) {
        if (this.age < 30) {
            incrementPercentage /= 2;
        }
        incrementPercentage /= 100;

        this.salary += this.salary * incrementPercentage;
        System.out.printf("%s %s gets %s leva", firstName, lastName, salary);
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", firstName, lastName, age);
    }
}
