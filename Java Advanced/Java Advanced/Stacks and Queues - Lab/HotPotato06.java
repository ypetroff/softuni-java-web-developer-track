import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int hotPotato = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kids = new ArrayDeque<>();

        for (String s : input) {
            kids.offer(s);
        }

        while (kids.size() > 1) {
            for (int i = 1; i < hotPotato; i++) {
                kids.offer(kids.poll()); //insert the exiting value until the hot potato number is reached
            }                              //when the cycle is ended the hot potato is at first position FIFO
            System.out.println("Removed " + kids.poll());
        }

        System.out.println("Last is " + kids.poll());
    }
}
