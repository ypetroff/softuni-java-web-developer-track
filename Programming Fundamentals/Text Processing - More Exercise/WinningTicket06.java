import java.util.Scanner;
import java.util.stream.IntStream;

public class WinningTicket06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String input = scanner.nextLine().replaceAll("\\s+", "").trim()
//                .replaceAll(",{2,}", ","); //.replaceAll("(?<!^,)", "");
//
//        if(input.charAt(0) == ',') {
//            input = input.substring(1);
//        }
//        if(input.charAt(input.length()- 1 ) == ',') {
//            input = input.substring(0, input.length() - 1);
//        }

        String[] tickets = scanner.nextLine().split(",\\s+");
        IntStream.range(0, tickets.length).forEach(i -> tickets[i] = tickets[i].trim());

        for (String ticket : tickets) {


            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String leftPart = ticket.substring(0, 10);
                String rightPart = ticket.substring(10);

                String leftResult = checkTicket(leftPart);
                String rightResult = checkTicket(rightPart);

                if(leftResult.charAt(0) == rightResult.charAt(0) && leftResult.length() > 5 && rightResult.length() > 5) {

                    String jackpot = "";
                    if(leftResult.length() == 10 && rightResult.length() == 10) {
                        jackpot = "Jackpot!";
                    }
                            System.out.printf("ticket \"%s\" - %d%c %s%n", ticket,
                                    Math.min(leftResult.length(), rightResult.length()), leftResult.charAt(0), jackpot);
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            }


        }
    }

    private static String checkTicket(String ticketHalf) {
       StringBuilder sb = new StringBuilder();
       char symbol;
        for (int i = 0; i < ticketHalf.length(); i++) {
            if(ticketHalf.charAt(i) == '@' || ticketHalf.charAt(i) == '#' ||
                    ticketHalf.charAt(i) == '$' || ticketHalf.charAt(i) == '^') {
                symbol = ticketHalf.charAt(i);
                sb.append(symbol);
                for (int j = i + 1; j < ticketHalf.length(); j++) {
                    if(symbol == ticketHalf.charAt(j)) {
                        sb.append(ticketHalf.charAt(j));
                    }else {
                        break;
                    }
                }
            }
            if(sb.length() > 5) {
                return sb.toString();
            }else {
                if(i > 4) {
                    break;
                }
                sb.setLength(0);
            }
        }
        return " ";
    }
}
