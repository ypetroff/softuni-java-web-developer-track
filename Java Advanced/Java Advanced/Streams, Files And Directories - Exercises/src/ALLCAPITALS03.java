import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public class ALLCAPITALS03 {
    public static void main(String[] args) throws IOException {
        String rootDirectory = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader reader = Files.newBufferedReader(Paths.get(rootDirectory));
        PrintStream printStream = new PrintStream("AllCapsOutput.txt");
        String line = reader.readLine();
        while (!line.isEmpty()) {
          printStream.println(line.toUpperCase(Locale.ROOT));
            line = reader.readLine();
        }
    }
}
