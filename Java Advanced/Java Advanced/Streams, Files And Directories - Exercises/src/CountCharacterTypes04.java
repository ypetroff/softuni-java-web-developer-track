import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes04 {
    public static void main(String[] args) throws IOException {
        String rootDirectory = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        PrintStream printStream = new PrintStream("CountCharsType04.txt");
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o','u');
        List<Character> punctuation = Arrays.asList('!',',','.','?');
        int vowelsCount = 0, punctuationCount = 0, consonantsCount = 0;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(rootDirectory))) {
            String line = reader.readLine().replaceAll("\\s+", "");
            while (!line.isEmpty()) {
                for (char c : line.toCharArray()) {
                    if(vowels.contains(c)) {
                        vowelsCount++;
                    }else if (punctuation.contains(c)) {
                        punctuationCount++;
                    }else {
                        consonantsCount++;
                    }
                }
                line = reader.readLine().replaceAll("\\s+", "");
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            printStream.printf("Vowels: %d%nConsonants: %d%nPunctuation: %d", vowelsCount, consonantsCount, punctuationCount);
        }

    }
}
