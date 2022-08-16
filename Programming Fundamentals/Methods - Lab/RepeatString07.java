import java.util.Scanner;

public class RepeatString07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int repetitions = Integer.parseInt(scanner.nextLine());

        printText(text, repetitions);
    }

    private static void printText(String text, int repetitions) {
        for (int i = 0; i < repetitions; i++) {
            System.out.print(text);
        }
    }


}
