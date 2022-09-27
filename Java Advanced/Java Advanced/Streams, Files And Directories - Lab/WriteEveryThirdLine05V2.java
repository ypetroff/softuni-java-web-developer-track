import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteEveryThirdLine05V2 {
    public static void main(String[] args) throws IOException {

        String fileDirectory = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        Path path = Paths.get(fileDirectory);
        List<String> allLines = Files.readAllLines(path);
        PrintStream printStream = new PrintStream("problem5_solution2.txt");

        for (int i = 2; i < allLines.size(); i+=3) {
            printStream.println(allLines.get(i));
        }
    }
}
