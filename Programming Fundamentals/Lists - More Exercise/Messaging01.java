import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> text = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());

        List<String> decryptedMessage = new ArrayList<>();

        for (Integer number : numbers) {
            int digit = getDigit(number, text);

            String symbol = text.get(digit);
            text.remove(digit);
            decryptedMessage.add(symbol);
        }

        for (String symbol : decryptedMessage) {
            System.out.print(symbol);
        }
    }

    private static int getDigit(Integer integer, List<String> text) {
        int digit, sum = 0;

        while (integer > 0) {
            digit = integer % 10;
            sum+=digit;
            integer/=10;
        }

        if(sum >= text.size()) {
            sum-= text.size();
        }
        return sum;
    }
}
