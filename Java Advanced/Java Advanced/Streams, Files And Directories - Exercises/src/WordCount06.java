import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordCount06 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        Map<String, Integer> wordCounter = new TreeMap<>(/*String.CASE_INSENSITIVE_ORDER*/);

        String[] keyWord = Files.readString(Paths.get("C:\\Users\\Yordan Petroff\\Desktop\\" +
                "Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"), StandardCharsets.UTF_8).split("\\s+");

        for (String s : keyWord) {
            wordCounter.put(s, 0);
        }


        try(BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line = reader.readLine();
            while (!line.isEmpty()) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if(wordCounter.containsKey(word)) {
                        wordCounter.put(word, wordCounter.get(word) + 1);
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            PrintStream printStream = new PrintStream("WordCounterOutput.txt");
            wordCounter.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(x -> printStream.printf("%s - %d%n", x.getKey(), x.getValue()));
        }
        }
    }

