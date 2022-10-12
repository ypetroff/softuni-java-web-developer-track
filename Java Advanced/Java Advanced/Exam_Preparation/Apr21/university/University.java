package Apr21.university;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {

    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStudents() {
        return this.students.stream().map(Student::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {

        if (this.students.size() < this.capacity) {

            if (!isAlreadyRegistered(student)) {
                this.students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            }

            return "Student is already in the university";
        }
        return "No seats in the university";
    }

    private boolean isAlreadyRegistered(Student student) {
        return this.students.contains(student);
    }

    public String dismissStudent(Student student) {

        if (isAlreadyRegistered(student)) {
            this.students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    public String getStudent(String firstName, String lastName) {
        return this.students.stream().filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                .map(Student::toString).collect(Collectors.joining());
    }

    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        for (Student student : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    student.getFirstName(), student.getLastName(), student.getBestSubject())).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
