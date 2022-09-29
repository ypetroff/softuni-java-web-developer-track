import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SumBytes02 {
    public static void main(String[] args) {
        String rootDirectory = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(rootDirectory))) {
            String line = reader.readLine();
            while (!line.isEmpty()) {
                char[] symbols = line.toCharArray();
                for (char symbol : symbols) {
                    sum+=symbol;
                }
                line = reader.readLine();
        }
        } catch (IOException exception) {
            exception.printStackTrace();
        }finally {
            System.out.println(sum);
        }

    }
}
