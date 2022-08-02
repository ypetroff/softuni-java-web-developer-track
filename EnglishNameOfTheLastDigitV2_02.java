import java.util.Scanner;

public class EnglishNameOfTheLastDigitV2_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        double lastDigit = (double)input % 10;
        String[] output = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        System.out.println(output[(int)lastDigit]);
    }
}
