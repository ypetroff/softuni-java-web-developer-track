import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive12 {
    private static final String FIRST_FILE_PATH = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
            "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
    private static final String SECOND_FILE_PATH = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
            "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
    private static final String THIRD_FILE_PATH = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
            "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
    private static final String ZIP_FILE_PATH = "C:\\Users\\Yordan Petroff\\Desktop\\Streams, Files and Directories\\" +
            "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\zipfile.zip";

    public static void main(String[] args) {

        try(ZipOutputStream ZOS = new ZipOutputStream(new FileOutputStream(ZIP_FILE_PATH))) {

            addFileToZip(FIRST_FILE_PATH,ZOS);
            addFileToZip(SECOND_FILE_PATH,ZOS);
            addFileToZip(THIRD_FILE_PATH,ZOS);

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    private static void addFileToZip(String path,ZipOutputStream ZOS) throws IOException {
        File file = new File(path);
        FileInputStream FIS = new FileInputStream(file);
        String[]files=path.split("/");
        String fileName=files[files.length-1];
        ZipEntry zipEntry=new ZipEntry(fileName);
        ZOS.putNextEntry(zipEntry);
        byte[] bytes=new byte[1024];
        int length;
        while ((length=FIS.read(bytes))>=0){
            ZOS.write(bytes,0,length);
        }
        ZOS.closeEntry();
        FIS.close();
    }
}
