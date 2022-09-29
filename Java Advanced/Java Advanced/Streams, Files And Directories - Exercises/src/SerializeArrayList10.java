import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SerializeArrayList10 {
  private static final String path = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
            "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\list.ser.";
    public static void main(String[] args) throws IOException {

        List<Double> list = Arrays.asList(1.0, 2.8, 5.6, 8.2);
        try(FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try(FileInputStream inputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            List<Double> deserializeList = (List<Double>) objectInputStream.readObject();
            deserializeList.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
