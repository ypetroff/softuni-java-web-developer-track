import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().trim().split("\\s*,+\\s+");

        for (String ticket : tickets) {
            if (ticket.length() == 20) {
                String firstHalf = ticket.substring(0, 10);
                String secondHalf = ticket.substring(10);

                String leftResult = ticketValue(firstHalf);
                String rightResult = ticketValue(secondHalf);

                if (leftResult.charAt(0) == rightResult.charAt(0) && rightResult.length() > 5 && leftResult.length() > 5) {
                    String jackpot = "";
                    if (leftResult.length() == 10 && rightResult.length() == 10) {
                        jackpot = "Jackpot!";
                    }
                    int consecutiveness = Math.min(leftResult.length(), rightResult.length());
                    System.out.printf("ticket \"%s\" - %d%c %s%n", ticket, consecutiveness, leftResult.charAt(0), jackpot);

                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            } else {
                System.out.println("invalid ticket");
            }

        }
    }

    private static String ticketValue(String halfTicket) {
        String regex = "\\${6,}|@{6,}|#{6,}|\\^{6,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(halfTicket);
        String output = " ";
        while (matcher.find()) {
            output = matcher.group();
        }

        return output;
    }
}
