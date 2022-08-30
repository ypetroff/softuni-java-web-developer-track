package Students05;

public class Student {
    private String firstName;
    private String lastName;
    private double grade;

    public Student(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    String printStudents() {
        return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
    }
}
