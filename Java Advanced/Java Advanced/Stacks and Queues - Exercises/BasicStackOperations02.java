import java.util.*;

public class BasicStackOperations02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().trim().split("\\s+");

        int numbersToPush = Integer.parseInt(nums[0]); /// scanner.nextInt
        int numbersToPop = Integer.parseInt(nums[1]);
        int checkForNumber = Integer.parseInt(nums[2]);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")) // nextInt? but without stream
                .mapToInt(Integer::parseInt)
                .limit(numbersToPush)
                .forEach(stack::push);
//        stack.stream()
//                .limit(numbersToPop).forEach(e -> stack.pop(e));

        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }

        if (stack.contains(checkForNumber)) {
            System.out.println("true");
        } else {
            int min = Integer.MAX_VALUE;
            if (stack.isEmpty()) {
                min = 0;
            } else {
                for (int number : stack) {
                    min = Math.min(number, min);
                }
            }
            System.out.println(min); ///Collections.min(stack).sout
        }
//        int[] commands = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        Arrays.stream(numbers, 0, commands[0]).forEach(stack::push);
//        IntStream.range(0, commands[1]).filter(i -> !stack.isEmpty()).forEach(i -> stack.pop());
//        if(stack.isEmpty()){
//            System.out.println(0);
//        }else if(stack.contains(commands[2])){
//            System.out.println("true");
//        }else{
//            System.out.println(Collections.min(stack));
//        }
    }
}
