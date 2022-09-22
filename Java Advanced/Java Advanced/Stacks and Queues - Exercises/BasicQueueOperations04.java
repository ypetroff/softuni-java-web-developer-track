import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BasicQueueOperations04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] instructions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .limit(instructions[0]).forEach(stack::offer);
        IntStream.range(0, instructions[1]).filter(e -> !stack.isEmpty()).forEach(e -> stack.poll());

        if(stack.contains(instructions[2])) {
            System.out.println("true");
        }else if(stack.isEmpty()) {
            System.out.println(0);
        }else {
            System.out.println(Collections.min(stack));
        }
    }
}
