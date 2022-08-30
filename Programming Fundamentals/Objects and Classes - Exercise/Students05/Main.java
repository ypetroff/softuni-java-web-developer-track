package Students05;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String[] command = scanner.nextLine().split(" ");
            String firstName = command[0];
            String lastName = command[1];
            double grade = Double.parseDouble(command[2]);
            Student student = new Student(firstName, lastName, grade);
            studentList.add(student);
        }

        List<Student> orderedList = studentList.stream()
                .sorted(Comparator.comparing(Student::getGrade))
                .collect(Collectors.toList());
        Collections.reverse(orderedList);

        orderedList.forEach(p -> System.out.println(p.printStudents()));
    }
}
