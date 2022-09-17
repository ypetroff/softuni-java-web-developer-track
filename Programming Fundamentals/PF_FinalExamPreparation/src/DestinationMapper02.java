import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String places = scanner.nextLine();
        String regex = "(?<marker>[=\\/])(?<place>[A-Z][A-Za-z]{2,})\\k<marker>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(places);
        List<String> destinations = new ArrayList<>();
        int points = 0;

        while(matcher.find()) {
            destinations.add(matcher.group("place"));
            points+= matcher.group("place").length();
        }

        System.out.println("Destinations: " + String.join(", ", destinations));
        System.out.printf("Travel Points: %d", points);
    }
}
