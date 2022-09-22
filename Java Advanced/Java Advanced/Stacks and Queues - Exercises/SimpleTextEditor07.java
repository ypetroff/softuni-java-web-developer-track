import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOperations = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < numberOfOperations; i++) {
            String[] currentCommand = scanner.nextLine().split("\\s+");

            switch (Integer.parseInt(currentCommand[0])) {
                case 1:
                    stack.push(text.toString());
                    text.append(currentCommand[1]);
                    break;
                case 2:
                    stack.push(text.toString());
                    text.delete(text.length() - Integer.parseInt(currentCommand[1]), text.length());
                    break;
                case 3:
                    System.out.println(text.charAt(Integer.parseInt(currentCommand[1]) - 1));
                    break;
                case 4:
                    text.setLength(0);
                    text.append(stack.pop());
                    break;
            }
        }
    }
}
