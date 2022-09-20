import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> back = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        String command;
        String currentURL = "";

        while (!"Home".equals(command = scanner.nextLine())) {
            if(!command.equals("back") && !command.equals("forward")) {
                if(currentURL.length() >= 1) {
                    back.push(currentURL);
                }
                currentURL = command;
                forward.clear();
            }else if (command.equals("back")) {
                if(back.isEmpty()) {
                    System.out.println("no previous URLs");
                    continue;
                }else {
                    forward.addFirst(currentURL);
                    currentURL = back.pop();
                }
            }else {
                if(forward.isEmpty()) {
                    System.out.println("no next URLs");
                    continue;
                }else {
                    back.push(currentURL);
                    currentURL = forward.poll();
                }
            }
            System.out.println(currentURL);
        }
    }
}
