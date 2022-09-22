import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String number : numbers) {
            stack.push(Integer.parseInt(number));
        }

        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }

//        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
//        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(numbersStack::push);
//        while (!numbersStack.isEmpty()){
//            System.out.print(numbersStack.pop()+" ");
//        }
    }
}
