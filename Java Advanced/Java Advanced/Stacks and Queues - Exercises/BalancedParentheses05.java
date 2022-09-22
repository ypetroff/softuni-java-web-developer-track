import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] elements = scanner.nextLine().toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        if(elements.length % 2 == 0) {
            boolean isBalanced = true;
            for (char parentheses : elements) {
                if (parentheses == '{' || parentheses == '[' || parentheses == '(') {
                    stack.push(parentheses);
                } else {
                    if (!stack.isEmpty()) {
                        if (parentheses == ']') {
                            isBalanced = stack.pop() == '[';
                        } else if (parentheses == '}') {
                            isBalanced = stack.pop() == '{';
                        } else if (parentheses == ')') {
                            isBalanced = stack.pop() == '(';
                        }
                    } else {
                        isBalanced = false;
                    }

                }
                if (!isBalanced) {
                    break;
                }
            }

            if(!stack.isEmpty()) {
                isBalanced = false;
            }
            if(isBalanced) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }  else {
            System.out.println("NO");
        }

    }
}
