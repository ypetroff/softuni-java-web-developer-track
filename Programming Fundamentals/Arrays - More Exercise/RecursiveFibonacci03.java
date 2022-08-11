import java.util.Scanner;

public class RecursiveFibonacci03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int position = Integer.parseInt(scanner.nextLine());

        if (position == 0){
            System.out.println(0);
        }

        if (position >= 1 && position <= 50) {
            if (position < 2) {
                System.out.println(1);
            } else {
                long[] fibonacciSequence = new long[position];
                fibonacciSequence[0] = 1;
                fibonacciSequence[1] = 1;

                for (int i = 2; i < position; i++) {

                    fibonacciSequence[i] = fibonacciSequence[i - 2] + fibonacciSequence[i -1];
                }
                System.out.println(fibonacciSequence[position - 1]);
            }

        }
    }
}

