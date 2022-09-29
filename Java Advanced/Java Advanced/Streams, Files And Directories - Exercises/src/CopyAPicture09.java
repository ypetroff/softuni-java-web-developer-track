import java.io.*;

public class CopyAPicture09 {
    public static void main(String[] args) throws IOException {
        String pathIn = "D:\\Pictures\\ASL.jpg";
        String pathOut = "C:\\Users\\Yordan Petroff\\Desktop\\copy-ASL.jpg";
        BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(pathIn));
        BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(pathOut));
        //   TODO: first while does not produce the required output
//        byte[] buffer = new byte[1024];
//        int length;
//        while ((length = fileInputStream.read()) > 0) {
//            fileOutputStream.write(buffer, 0, length);
//            fileOutputStream.flush();
//        }

//        Files.copy(Paths.get(pathIn),
//                Paths.get(pathOut),
//                StandardCopyOption.REPLACE_EXISTING);
        int oneByte;
        while ((oneByte=fileInputStream.read())!=-1){
            fileOutputStream.write(oneByte);
        }

        fileInputStream.close();
        fileOutputStream.close();

    }
}
