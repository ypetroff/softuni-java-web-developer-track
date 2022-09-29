package com.company;

import java.io.*;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {
        File copied = new File("D:\\Pictures\\copy-ASL.jpg");
        try (
                InputStream in = new BufferedInputStream(
                        new FileInputStream("D:\\Pictures\\ASL.jpg"));
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream("D:\\Pictures\\copy_ASL.jpg"))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }

//        assertThat("D:\\Pictures\\copy_ASL.jpg").exists();
//        assertThat(Files.readAllLines("D:\\Pictures\\ASL.jpg".toPath())
//                .equals(Files.readAllLines(copied.toPath())));
    }
}
