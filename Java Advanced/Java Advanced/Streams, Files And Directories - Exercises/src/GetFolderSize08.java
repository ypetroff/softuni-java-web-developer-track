import java.io.File;
import java.util.ArrayDeque;
import java.util.Objects;

public class GetFolderSize08 {
    public static void main(String[] args)  {

        ArrayDeque<File> queue = new ArrayDeque<>();

        int sum = 0;
File file = new File("C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
        "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

            queue.offer(file);

            while (!queue.isEmpty()) {
                File innerFile = queue.poll();
                for (File f : Objects.requireNonNull(innerFile.listFiles())) {
                    if(f.isDirectory()) {
                        queue.offer(f);
                    }else {
                        sum+= f.length();
                    }
                }
            }

            System.out.printf("Folder size: %d", sum);



    }
}
