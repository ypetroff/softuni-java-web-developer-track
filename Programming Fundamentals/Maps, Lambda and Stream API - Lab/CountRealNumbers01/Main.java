package CountRealNumbers01;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> map = new TreeMap<>();

        for (double num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
            }else {
                int occurrences = map.get(num);
                occurrences++;
                map.put(num, occurrences);
            }
        }

        DecimalFormat df = new DecimalFormat("#.#######");

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
