import java.util.*;
import java.util.function.Function;

public class ThePianist03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPieces = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> dataBase = new HashMap<>();

        for (int i = 0; i < numberOfPieces; i++) {
            String[] pieceInfo = scanner.nextLine().split("\\|");
            String piece = pieceInfo[0];
            String composer = pieceInfo[1];
            String key = pieceInfo[2];
            dataBase.put(piece, Arrays.asList(composer, key));
        }

        String command;
        while(!"Stop".equalsIgnoreCase(command = scanner.nextLine())) {
            String[] tokens = command.split("\\|");

            switch (tokens[0]) {
                case "Add":
                    if(!dataBase.containsKey(tokens[1])) {
                        dataBase.put(tokens[1],Arrays.asList(tokens[2], tokens[3]));
                        System.out.printf("%s by %s in %s added to the collection!%n", tokens[1], tokens[2], tokens[3]);
                    }else {
                        System.out.printf("%s is already in the collection!%n", tokens[1]);
                    }
                    break;
                case "Remove":
                    if(dataBase.containsKey(tokens[1])) {
                        dataBase.remove(tokens[1]);
                        System.out.printf("Successfully removed %s!%n", tokens[1]);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", tokens[1]);
                    }
                    break;
                case "ChangeKey":
                    if(dataBase.containsKey(tokens[1])) {
                        dataBase.get(tokens[1]).set(1, tokens[2]);
                        System.out.printf("Changed the key of %s to %s!%n", tokens[1], tokens[2]);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", tokens[1]);
                    }
                    break;
            }
        }

        dataBase.entrySet().stream()
                .sorted(Comparator.comparing((Function<Map.Entry<String, List<String>>, String>) Map.Entry::getKey).thenComparing(e -> e.getValue().get(0)))
                .forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
