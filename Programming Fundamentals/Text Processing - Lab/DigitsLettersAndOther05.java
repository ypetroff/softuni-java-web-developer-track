import java.util.Scanner;

public class DigitsLettersAndOther05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        StringBuilder firstLine = new StringBuilder();
        StringBuilder secondLine = new StringBuilder();
        StringBuilder thirdLine = new StringBuilder();

        for (char c : input) {

            if (Character.isDigit(c)) {
                firstLine.append(c);
            } else if (Character.isAlphabetic(c)) {
                secondLine.append(c);
            } else {
                thirdLine.append(c);
            }

        }
        System.out.println(firstLine);
        System.out.println(secondLine);
        System.out.println(thirdLine);
    }
}
