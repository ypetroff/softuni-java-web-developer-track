import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int counter = 1;
       boolean /*resourceIsKnown  = false, */ quantityIsKnown = false;

        Map<String, Long> minedResources = new LinkedHashMap<>();
        String resource = "";
        long quantity = 0;

        while (!input.equalsIgnoreCase("stop")) {

            if(counter % 2 == 0) {
                quantity = Long.parseLong(input);
                quantityIsKnown = true;
            } else {
                resource = input;
             //   resourceIsKnown = true;
            }

            if (quantityIsKnown) {
                minedResources.putIfAbsent(resource, 0L);
                minedResources.put(resource, minedResources.get(resource) + quantity);
             //   resourceIsKnown = false;
                quantityIsKnown = false;
            }
            counter++;
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Long> entry : minedResources.entrySet()) {
            DecimalFormat df = new DecimalFormat("##########");
            System.out.printf("%s -> %s%n", entry.getKey(), df.format(entry.getValue()) );
        }
    }
}
