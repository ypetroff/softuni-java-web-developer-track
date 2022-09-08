import java.util.*;

public class Snowwhite04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        Map<String, Integer> dwarfCatalogue = new LinkedHashMap<>();

        while (!"Once upon a time".equals(input = scanner.nextLine())) {
            String[] dwarf = input.split(" <:> ");
            String name = dwarf[0];
            String hatColour = dwarf[1];
            int physics = Integer.parseInt(dwarf[2]);
            String colourAndName = String.format("(%s) %s <->", hatColour, name);

            dwarfCatalogue.putIfAbsent(colourAndName, 0);

            if (dwarfCatalogue.get(colourAndName)  < physics) {
                dwarfCatalogue.put(colourAndName, physics);
            }
        }

        Map<String, Integer> countColours = new HashMap<>();
        dwarfCatalogue.forEach((key, value) -> {
                    String[] colour = key.split(" ");
                    countColours.put(colour[0], !countColours.containsKey(colour[0]) ? 1 : countColours.get(colour[0]) + 1);
                });

            dwarfCatalogue.entrySet().stream()
                    .sorted((x1, x2) -> {
                        int sort = x2.getValue().compareTo(x1.getValue());
                        if (sort == 0) {
                            String[] colourX1 = x1.getKey().split(" ");
                            String[] colourX2 = x2.getKey().split(" ");
                            sort = countColours.get(colourX2[0]).compareTo(countColours.get(colourX1[0]));
                        }
                        return sort;
                    })
                    .forEach(p -> System.out.printf("%s %d%n", p.getKey(), p.getValue()));
        }
    }
