import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers04 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileStream = new FileInputStream(path);
        PrintStream printStream = new PrintStream("ExtractIntegers04_output.txt");
        Scanner scanner = new Scanner (fileStream);

        while (scanner.hasNext()) {
            if(scanner.hasNextInt()) {
                printStream.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}
