import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringExplosion07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        List<Character> listedChars = new ArrayList<>();

        for (char c : input) {
            listedChars.add(c);
        }
        int power = 0;
        for (int i = 0; i < listedChars.size(); i++) {
            if (listedChars.get(i).equals('>')) {
//                if(i  == listedChars.size() - 1) {
//                    break;
//                }
                i++;
                power = listedChars.get(i) - 48;

//                if(i  == listedChars.size() - 1) {
//                    power = 1;
//                }

            }

            while (power > 0 && i < listedChars.size()) {
                if (listedChars.get(i).equals('>')) {
                    i++;
                    power += listedChars.get(i) - 48;
                    if(power >= listedChars.size()) {
                        power = listedChars.size() -1;
                    }
                }
                listedChars.remove(i);
                power--;
                if (power == 0 && listedChars.get(i).equals('>')) {
                    i--;
                }
            }
        }

        String output = listedChars.toString().replaceAll("[\\[\\],\\s+]", "");
        System.out.println(output);


    }
}
