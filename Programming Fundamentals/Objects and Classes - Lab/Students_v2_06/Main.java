package Students_v2_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<Student2> studentData = new ArrayList<>();

        while (!command.equals("end")) {
            String[] studentInfo = command.split(" ");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            int age = Integer.parseInt(studentInfo[2]);
            String homeTown = studentInfo[3];

            boolean newStudent = true;
            if (studentData.size() > 0) {
                for (Student2 student2 : studentData) {
                    if (student2.getFirstName().equals(firstName) && student2.getLastName().equals(lastName)) {
                        student2.setAge(age);
                        student2.setHomeTown(homeTown);
                        newStudent = false;
                        break;
                    }
                }
            }

            if (newStudent) {
                Student2 student = new Student2(firstName, lastName, age, homeTown);
                studentData.add(student);
            }


            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        for (Student2 student : studentData) {
            if (student.getHomeTown().equals(command)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
