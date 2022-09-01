import java.util.*;

public class WordSynonyms02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> dictionary = new LinkedHashMap<>();


        for (int i = 0; i < cycles; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            dictionary.putIfAbsent(word, new ArrayList<>());
            dictionary.get(word).add(synonym);

//            if(!dictionary.containsKey(word)) {
//                List<String> currentSynonym = new ArrayList<>();
//                currentSynonym.add(synonym);
//                dictionary.put(word, currentSynonym);
//              //  dictionary.get(word).add(synonym);
//            } else {
//                List<String> currentSynonym = new ArrayList<>();
//                currentSynonym.add(synonym);
//                dictionary.put(word, currentSynonym);
//            }

        }

        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
         //   String output = entry.getValue().toString().replaceAll("[\\[\\]]", "");
          //  System.out.printf("%s - %s%n", entry.getKey(), output);
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));

        }
    }
}

