import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentInput = scanner.nextLine();
        int maxNumber= Integer.MIN_VALUE;
        while (!currentInput.equals("Stop")) {
            int currentNumber = Integer.parseInt(currentInput);
            if (currentNumber > maxNumber) {
                maxNumber = currentNumber;
            }
            currentInput = scanner.nextLine();
        }
        System.out.println(maxNumber);
    }
}
