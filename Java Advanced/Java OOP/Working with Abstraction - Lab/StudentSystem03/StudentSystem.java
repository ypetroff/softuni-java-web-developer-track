package StudentSystem03;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void parseCommand(String[] args) {


        switch (args[0]) {
            case "Create":

                createStudent(args);

                break;
            case "Show":

                showStudent(args);

                break;
        }
    }

    private void createStudent(String[] args) {
        var name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade = Double.parseDouble(args[3]);

        if (!students.containsKey(name)) {
            var student = new Student(name, age, grade);
            students.put(name, student);
        }
    }

    private void showStudent(String[] args) {

        var displayName = args[1];
        if (students.containsKey(displayName)) {
            var student = students.get(displayName);
            StringBuilder sb = new StringBuilder(student.toString());

            if (student.getGrade() >= 5.00) {
                sb.append(" Excellent student.");
            } else if (student.getGrade() >= 3.50) {
                sb.append(" Average student.");
            } else {
                sb.append(" Very nice person.");
            }

            System.out.println(sb);
        }
    }
}
