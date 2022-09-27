import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Objects;

public class NestedFolders08 {
    public static void main(String[] args) throws IOException {
        String rootDirectory = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources";
        PrintStream printStream = new PrintStream("Problem8Output.txt");
        File file = new File(rootDirectory);
        ArrayDeque<File> files = new ArrayDeque<>(); //BFS - offer poll // DFS - push, pop
        files.offer(file);

        int counter = 0;
        while (!files.isEmpty()) {
            File innerFile = files.poll();
            for (File listFile : Objects.requireNonNull(innerFile.listFiles())) {
          //      printStream.println(listFile.getName());
                if (listFile.isDirectory()) {
                    printStream.println(listFile.getName());
                    files.offer(listFile);
                    counter++;
                }
            }
        }
        printStream.printf("%d folders", counter);

    }
}
