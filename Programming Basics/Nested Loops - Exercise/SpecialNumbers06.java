import java.util.Scanner;

public class SpecialNumbers06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1111; i <= 9999; i++) {
            int counter = 0;
            int workNumber = i;
            int loopNumber = workNumber % 10;
            while (loopNumber > 0) {
                if (n % loopNumber == 0) {
                    counter++;
                    workNumber = workNumber / 10;
                    loopNumber = workNumber % 10;
                } else {
                break;
                }
            }
            if (counter == 4) {
                System.out.printf("%d ", i);
            }
        }
    }
}

