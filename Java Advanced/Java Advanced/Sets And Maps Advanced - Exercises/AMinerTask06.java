import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Long> map = new LinkedHashMap<>(); // or String, String
        String command;
        int counter = 1;
        String prev = "";
        while(!"stop".equalsIgnoreCase(command=scanner.nextLine())) {
             if(counter % 2 != 0) {
                 map.putIfAbsent(command, 0L); //or ""
                 prev = command;
             }else {
                 map.put(prev, map.get(prev) + Long.parseLong(command));
             }
             counter++;
        }

        map.forEach((k,v) -> System.out.printf("%s -> %d%n", k, v));
    }
}
