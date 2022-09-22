import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] expression = scanner.nextLine().split("\\s+");


        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String s : expression) {
           char c = s.charAt(0);

            if(c != '(' && c != ')' && c != '*' && c != '/' && c != '+' && c != '-') {
                queue.offer(s);
                continue;
            }
            if(stack.isEmpty() || c == '(') {
               stack.push(s);
                continue;
            }
            if(c == ')') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    queue.offer(stack.pop());
                }
                stack.pop();
            }

            if(c == '*' || c == '/') {
                 if(stack.peek().equals("*") || stack.peek().equals("/")) {
                    while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        queue.offer(stack.pop());
                    }
                }
                stack.push(s);
            } else if (c == '+' || c == '-') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    queue.offer(stack.pop());
                }
                stack.push(s);
            }
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        while (!queue.isEmpty())  {
            System.out.print(queue.poll() + " ");
        }

    }
}
