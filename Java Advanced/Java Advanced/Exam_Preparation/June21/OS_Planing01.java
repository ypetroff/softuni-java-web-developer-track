package June21;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OS_Planing01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(taskStack::push);

        ArrayDeque<Integer> threadQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(threadQueue::offer);

        int taskToKill = Integer.parseInt(scanner.nextLine());

        boolean jobDone = false;
        int thread = 0;

        while (!jobDone) {

            int currentTask = taskStack.peek();
            thread = threadQueue.peek();

            if(currentTask == taskToKill) {
                jobDone = true;
                continue;
            }

            if(thread >= currentTask) {
                taskStack.pop();
            }
            threadQueue.poll();

        }

        System.out.printf("Thread with value %d killed task %d%n", thread, taskToKill);

        String output = threadQueue.stream().map(String::valueOf).collect(Collectors.joining(" "));

        System.out.println(output);
    }
}
