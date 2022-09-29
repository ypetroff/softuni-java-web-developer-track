import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines01 {
    public static void main(String[] args) throws IOException {
        String rootDirectory = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader reader = Files.newBufferedReader(Paths.get(rootDirectory));

        String line = reader.readLine();
        while (!line.isEmpty()) {
            int sum = 0;
            char[] symbols = line.toCharArray();
            for (char symbol : symbols) {
                sum+=symbol;
            }
            System.out.println(sum);
            line = reader.readLine();
        }
    }

}
