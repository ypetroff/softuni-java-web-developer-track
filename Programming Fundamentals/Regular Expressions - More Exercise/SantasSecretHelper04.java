import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        String input;

        while (!"end".equals(input = scanner.nextLine())) {
            char[] decoder = input.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : decoder) {
                c-=key;
                sb.append(c);
            }
            String regex = "[^@\\-!:>]*@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<behavior>[G|N])![^@\\-!:>]*"; //[A-Za-z] - Capital and small letters int the word
            Pattern pattern = Pattern.compile(regex);                                                   // [A-Za][a-z]
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()){

                if(matcher.group("behavior").equals("G")){
                    System.out.println(matcher.group("name"));
                }
            }
        }
    }
}
