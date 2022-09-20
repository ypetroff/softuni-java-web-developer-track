import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> URLs = new ArrayDeque<>();
        String command;
        while (!"Home".equalsIgnoreCase(command=scanner.nextLine())) {
            if(command.equals("back")) {
                if(URLs.size() <= 1) {
                    System.out.println("no previous URLs");
                    continue;
                } else {
                    URLs.pop();
                }
            }else {
                    URLs.push(command);
            }
            if(!URLs.isEmpty()) {
                System.out.println(URLs.peek());
            }

        }
    }
}
