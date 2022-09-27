import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;


public class WriteToFile02 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileStream = new FileInputStream(path);
        int oneByte = fileStream.read();
        List<Character> charsToRemove = Arrays.asList(',', '.', '!', '?');
        PrintStream printStream = new PrintStream("out.txt");

        while (oneByte != -1) {
            char symbol = (char) oneByte;
            if(!charsToRemove.contains((char) oneByte)) {
                printStream.print(symbol);
            }
            oneByte = fileStream.read();
        }
    }
}
