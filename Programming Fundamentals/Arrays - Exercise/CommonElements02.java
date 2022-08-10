import java.util.Scanner;

public class CommonElements02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input2 = scanner.nextLine().split(" ");
        String[] input1 = scanner.nextLine().split(" ");

        for (String s : input1) {
            for (String value : input2) {
                if (s.equals(value)) {
                    System.out.printf("%s ", s);
                }
            }
        }
    }
}
