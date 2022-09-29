import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeTwoFiles07 {
    public static void main(String[] args) throws IOException {

        PrintStream printStream = new PrintStream("combinedOutput.txt");
        try(BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Yordan Petroff\\Desktop\\" +
                "Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"))) {
            String digit = reader.readLine();
            while (!digit.isEmpty()) {
                printStream.println(digit);
                digit = reader.readLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try(BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Yordan Petroff\\Desktop\\" +
                    "Streams, Files and Directories\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"))) {
                String digit = reader.readLine();
                while (!digit.isEmpty()) {
                    printStream.println(digit);
                    digit = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
