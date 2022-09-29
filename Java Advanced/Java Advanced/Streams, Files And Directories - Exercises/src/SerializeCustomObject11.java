import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SerializeCustomObject11 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> letters = Arrays.asList("A", "B", "C");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("output.txt"));

        outputStream.writeObject(letters);
        outputStream.close();


        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("output.txt"));

        List<String> getLetters = (List<String>) inputStream.readObject();

        for (String letter : getLetters) {
            System.out.println(letter);
        }
    }
}
