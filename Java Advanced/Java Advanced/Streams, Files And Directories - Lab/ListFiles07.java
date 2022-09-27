import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;

public class ListFiles07 {
    public static void main(String[] args) throws IOException {
        String folder = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        PrintStream printStream = new PrintStream("Problem7Output.txt");
        File file = new File(folder);
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            if(listFile.isFile()) {
                printStream.printf("%s: [%d]%n", listFile.getName(), listFile.length());
            }

        }

    }
}
