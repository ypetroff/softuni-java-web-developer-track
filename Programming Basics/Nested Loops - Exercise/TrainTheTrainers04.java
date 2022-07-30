import java.util.Scanner;

public class TrainTheTrainers04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jury = Integer.parseInt(scanner.nextLine());
        double groupAverageGrade = 0;
        int counter = 0;
        String subject = scanner.nextLine();
        while (!subject.equals("Finish")) {
            double averageGrade;
            double totalGrades = 0;
            for (int i = 1; i <= jury; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                totalGrades += grade;
            }
            averageGrade = totalGrades / jury;
            System.out.printf("%s - %.2f.%n", subject, averageGrade);
            groupAverageGrade += averageGrade;
            counter++;
            subject = scanner.nextLine();
        }
        groupAverageGrade = groupAverageGrade / counter;
        System.out.printf("Student's final assessment is %.2f.", groupAverageGrade);
    }
}
