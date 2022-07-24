import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int allowedFails = Integer.parseInt(scanner.nextLine());
        int badGrades = 0;
        String task = scanner.nextLine();
        int grade = Integer.parseInt(scanner.nextLine());
        boolean failed = false;
        int score = 0;
        int count = 0;
        String currentTask = null;

        while (!task.equals("Enough")) {
            if (grade <= 4) {
                badGrades++;
                score += grade;
                count++;
                if (badGrades == allowedFails) {
                    System.out.printf("You need a break, %d poor grades.", badGrades);
                    failed = true;
                    break;
                }
                task = scanner.nextLine();
                if (!task.equals("Enough")) {
                    currentTask = task;
                    grade = Integer.parseInt(scanner.nextLine());
                }
                continue;
            }
            score += grade;
            count++;
            task = scanner.nextLine();
            if (!task.equals("Enough")) {
                currentTask = task;
                grade = Integer.parseInt(scanner.nextLine());
            }
        }
        double averageScore = (double) score / count;
        if (!failed) {
            System.out.printf("Average score: %.2f%n Number of problems: %d%nLast problem: %s", averageScore, count, currentTask);
        }
    }
}
