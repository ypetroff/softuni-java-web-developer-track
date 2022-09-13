import java.util.Scanner;

public class MorseCodeTranslator04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("[|]");

        StringBuilder stringBuilder = new StringBuilder();
        for (String word : input) {

            String[] wordAsLetters = word.split("\\s+");
            String[] a = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                    "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

            StringBuilder sb = new StringBuilder();
            for (String s : wordAsLetters) {

                switch (s) {
                    case ".-":
                        s = a[0];
                        break;
                    case "-...":
                        s = a[1];
                        break;
                    case "-.-.":
                        s = a[2];
                        break;
                    case "-..":
                        s = a[3];
                        break;
                    case ".":
                        s = a[4];
                        break;
                    case "..-.":
                        s = a[5];
                        break;
                    case "--.":
                        s = a[6];
                        break;
                    case "....":
                        s = a[7];
                        break;
                    case "..":
                        s = a[8];
                        break;
                    case ".---":
                        s = a[9];
                        break;
                    case "-.-":
                        s = a[10];
                        break;
                    case ".-..":
                        s = a[11];
                        break;
                    case "--":
                        s = a[12];
                        break;
                    case "-.":
                        s = a[13];
                        break;
                    case "---":
                        s = a[14];
                        break;
                    case ".--.":
                        s = a[15];
                        break;
                    case "--.-":
                        s = a[16];
                        break;
                    case ".-.":
                        s = a[17];
                        break;
                    case "...":
                        s = a[18];
                        break;
                    case "-":
                        s = a[19];
                        break;
                    case "..-":
                        s = a[20];
                        break;
                    case "...-":
                        s = a[21];
                        break;
                    case ".--":
                        s = a[22];
                        break;
                    case "-..-":
                        s = a[23];
                        break;
                    case "-.--":
                        s = a[24];
                        break;
                    case "--..":
                        s = a[25];
                        break;
                }

                sb.append(s);
            }
            stringBuilder.append(sb);
            stringBuilder.append(" ");
        }

        String message = stringBuilder.toString().trim();
        System.out.println(message);
    }
}
