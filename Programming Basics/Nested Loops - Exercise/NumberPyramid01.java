import java.util.Scanner;

public class NumberPyramid01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int currentNumber = 1;
        //boolean flag = false;
        loop:
        for (int rows = 1; rows <= n; rows++) {
            for (int colons = 1; colons <= rows; colons++) {
                if (currentNumber > n) {
                    //flag = true;
                    break loop;
                }
                System.out.printf("%d ", currentNumber);
                currentNumber++;
            }
            // if (flag) {
            //   break;
            //}
            System.out.println();
        }
    }
}
