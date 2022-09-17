import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String text = scanner.nextLine();

        //(?<separator>[#@])(?<word>[A-Za-z]{3,})\k<separator>\k<separator>\k<word>\k<separator>

        Pattern pattern = Pattern.compile("([@#])(?<word1>[A-Za-z]{3,})\\1\\1(?<word2>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);
        List<String> word1 = new ArrayList<>();
        List<String> word2 = new ArrayList<>();
         while(matcher.find()) {
            word1.add(matcher.group("word1"));
            word2.add(matcher.group("word2"));
        }

         if(word1.size() == 0) {
             System.out.println("No word pairs found!");
         } else {
             System.out.printf("%d word pairs found!%n", word1.size());
         }
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < word1.size(); i++) {
            String s1 = word1.get(i);
            String s2 = new StringBuilder(word2.get(i)).reverse().toString();

            if(s1.equals(s2)){
                indexes.add(i);
            }
        }

        if(indexes.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            for (int i = 0; i < indexes.size(); i++) {
                System.out.printf("%s <=> %s", word1.get(indexes.get(i)), word2.get(indexes.get(i)));

                if(i != indexes.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}
