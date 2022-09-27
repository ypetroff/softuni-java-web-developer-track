import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteEveryThirdLine05 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        PrintStream printStream = new PrintStream("EveryThirdLine05_output.txt");
        Scanner scanner = new Scanner(fileInputStream);
        int line = 0;

        while (scanner.hasNext()) {
            line++;
            if(line % 3 == 0) {
                printStream.println(scanner.nextLine());
            } else {
                scanner.nextLine();
            }
        }
    }
}
