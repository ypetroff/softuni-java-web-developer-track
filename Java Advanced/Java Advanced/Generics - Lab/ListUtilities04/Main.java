package ListUtilities04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = List.of("Luffy", "Zoro", "Sanji", "Nami", "Robin", "Chopper", "Franky", "Brook", "Ussop");
        System.out.println(ListUtils.getMax(stringList));
        System.out.println(ListUtils.getMin(stringList));

        List<Integer> ints = new ArrayList<>();
        System.out.println(ListUtils.getMax(ints));
    }
}
