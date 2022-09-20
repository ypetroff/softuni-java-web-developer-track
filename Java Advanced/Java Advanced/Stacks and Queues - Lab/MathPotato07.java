import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> kids = new ArrayDeque<>();
        for (String s : input) {
            kids.offer(s);
        }
        int hotPotato = Integer.parseInt(scanner.nextLine());
        int cycle = 1;

        while (kids.size() > 1) {

            for (int i = 1; i < hotPotato; i++) {
                kids.offer(kids.poll());
            }

            boolean isPrime = primeValidation(cycle);

            if (!isPrime) {
                System.out.println("Removed " + kids.poll());
            } else {
                System.out.println("Prime " + kids.peek());
            }

            cycle++;
        }
        System.out.println("Last is " + kids.poll()); // or peek
    }

    private static boolean primeValidation(int cycle) {
        if (cycle == 1) {
            return false;
        }
        if (cycle <= 3) {
            return true;
        }

        if (cycle % 2 == 0 || cycle % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= cycle; i += 6) {
            if(cycle % i == 0 || cycle % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
