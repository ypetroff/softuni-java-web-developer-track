package Students05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<Student> studentData = new ArrayList<>();

        while (!command.equals("end")) {
            String[] studentInfo = command.split(" ");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            int age = Integer.parseInt(studentInfo[2]);
            String homeTown = studentInfo[3];

            Student student = new Student(firstName, lastName, age, homeTown);
            studentData.add(student);

            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        for (Student student : studentData) {
            if (student.getHomeTown().equals(command)) {
                System.out.printf("%s %s is %d years old%n",student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
