import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        String first = input[0];
        String regexFirst = "(?<delimiter>[#|$|%|*|&])[A-Z]+\\k<delimiter>";
        String result = findSymbols(first, regexFirst).trim();
        result = result.substring(1, result.length() - 1);
        String[] capitalLetters = result.split("");

        String second = input[1];
        String regexSecond = "\\d+:0?\\d{1,2}";
        String[] charsAndLength = findSymbols(second, regexSecond).split("\\s");
        Map<String, Integer> startingLetterWordLength = new LinkedHashMap<>();
        for (String s : charsAndLength) {
            char startingLetter = (char)Integer.parseInt(s.split(":")[0]);
            int length = Integer.parseInt(s.split(":")[1]) + 1;
            startingLetterWordLength.put(String.valueOf(startingLetter), length);
        }

        String[] third = input[2].split("\\s+");

        for (String letter : capitalLetters) {
            for (String words : third) {
                if(words.charAt(0) == letter.charAt(0)) {
                    if(startingLetterWordLength.containsKey(letter)) {
                        if(words.length() == startingLetterWordLength.get(letter)) {
                            System.out.println(words);
                        }
                    }
                }
            }
        }

    }

    private static String findSymbols(String s, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
