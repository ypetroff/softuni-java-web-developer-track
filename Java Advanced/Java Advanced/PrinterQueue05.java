import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String input;
        while (!"print".equals(input = scanner.nextLine())) {
            if(input.equals("cancel") && queue.isEmpty()) {
                System.out.println("Printer is on standby");
            }else if(input.equals("cancel")) {
                System.out.println("Canceled " + queue.poll());
            }else {
                queue.offer(input);
            }
        }

        for (String s : queue) {
            System.out.println(s);
        }
    }
}
