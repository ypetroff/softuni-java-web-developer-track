import java.util.Scanner;

public class RefactorSpecialNumbers12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lastNumber = Integer.parseInt(scanner.nextLine());
        lastNumber = Math.abs(lastNumber);


        boolean specialNumber = false;
        for (int i = 1; i <= lastNumber; i++) {
            int currentNumber = i;
            int sum = 0;
            while (currentNumber > 0) {
               int num = currentNumber % 10; // if this line is as a comment and I use the comment below instead  the lines  16 and 17 in some case it gives compile time error... but why
                sum += num; //  sum+= currentNumber % 10;
                currentNumber /= 10;
            }
            if (sum == 5 || sum == 7 || sum == 11) {
                specialNumber = true;
            }
            String trueOrFalse = String.valueOf(specialNumber);
            trueOrFalse = trueOrFalse.substring(0, 1).toUpperCase() + trueOrFalse.substring(1);
            System.out.printf("%d -> %s%n", i, trueOrFalse);
            specialNumber = false;
        }
    }
}
