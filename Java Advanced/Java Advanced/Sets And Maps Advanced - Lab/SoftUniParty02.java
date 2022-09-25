import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> partyList = new TreeSet<>();

        String command;
        while(!"PARTY".equalsIgnoreCase(command=scanner.nextLine())) {
            partyList.add(command);
        }

        while(!"END".equalsIgnoreCase(command=scanner.nextLine())) {
            partyList.remove(command);
        }

        System.out.println(partyList.size());
        partyList.forEach(System.out::println);
    }
}
