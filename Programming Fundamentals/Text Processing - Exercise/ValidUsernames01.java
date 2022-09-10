import java.util.Scanner;

public class ValidUsernames01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        loop: for (String user : input) {
            if(user.length() > 2 && user.length() < 15) {
                char[] chars = user.toCharArray();
                for (char c : chars) {
                    if(!Character.isAlphabetic(c) && !Character.isDigit(c) && c != '-' && c != '_') {
                        continue loop;
                    }
                }
                System.out.println(user);
            }
        }
    }
}
