import java.util.Scanner;

public class G2ThirdTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String studentName = scanner.nextLine();
        int grade = 1;
        double marksSum = 0;
        int fail = 0;
        boolean isExcluded = false;
        while (grade <= 12) {
            double currentMark = Double.parseDouble(scanner.nextLine());
            if (currentMark < 4) {
                fail++;
                if (fail > 1) {
                    System.out.printf("%s has been excluded at %d grade", studentName, grade);
                    isExcluded = true;
                    break;
                }
                continue;
            }
            marksSum+=currentMark;
            grade++;
        }
        if (!isExcluded) {
            System.out.printf("%s graduated. Average grade: %.2f", studentName, marksSum / 12);
        }
    }
}
