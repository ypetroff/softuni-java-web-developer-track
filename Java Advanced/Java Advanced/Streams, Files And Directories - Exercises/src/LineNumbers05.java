import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers05 {
    public static void main(String[] args) throws IOException {
        String rootDirectory = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        PrintStream printStream = new PrintStream("LineNumbers05.txt");
        BufferedReader reader = Files.newBufferedReader(Paths.get(rootDirectory));
        int lineCount = 0;
        String line = reader.readLine();
        while (!line.isEmpty()) {
            lineCount++;
            printStream.printf("%d. %s%n",lineCount, line);
            line = reader.readLine();
        }
    }
}
