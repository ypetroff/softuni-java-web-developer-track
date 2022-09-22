import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fibonacci = Integer.parseInt(scanner.nextLine());

        //fibN = fib(n-1) + fib(n-2)
        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.offer(1L);
        stack.offer(1L);
        for (int i = 0; i < fibonacci; i++) {
            stack.offer(stack.poll() + stack.peek());
        }

        System.out.println(stack.poll());
    }
}
