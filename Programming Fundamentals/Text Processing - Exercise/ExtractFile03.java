import java.util.Scanner;

public class ExtractFile03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
    //    char backslash = 92;
        int startFile = input.lastIndexOf("\\\\");
       // int startFile = input.lastIndexOf(backslash);
        int endFileStartType = input.indexOf('.');

        String file = input.substring(startFile + 1, endFileStartType);
        String type = input.substring(endFileStartType +1);

        System.out.printf("File name: %s%n" +
                "File extension: %s", file, type);
    }
}
