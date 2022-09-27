import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CopyBytes03 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        PrintStream printStream = new PrintStream("CopyBytesOutput.txt");
        int oneByte = fileInputStream.read();

        while (oneByte != -1) {
            if((char) oneByte == ' ' || (char) oneByte == '\n') {
                printStream.write((char) oneByte);
            } else {
                printStream.print(oneByte);
            }
           oneByte = fileInputStream.read();
        }
    }
}
