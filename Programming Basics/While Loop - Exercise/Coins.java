//import java.text.DecimalFormat;
import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double change = Double.parseDouble(scanner.nextLine());
        double changeSt = Math.round(change * 100);
        int coins = 0;
        while (changeSt > 0) {
            if (changeSt >= 200) {
                changeSt-=200;
                coins++;
            } else if (changeSt >= 100) {
                changeSt-=100;
                coins++;
            } else if (changeSt >= 50) {
                changeSt-=50;
                coins++;
            }else if (changeSt >= 20) {
                changeSt-=20;
                coins++;
            }else if (changeSt >= 10) {
                changeSt-=10;
                coins++;
            }else if (changeSt >= 5) {
                changeSt-=5;
                coins++;
            }else if (changeSt >=2) {
                changeSt-=2;
                coins++;
            }else if (changeSt >= 1) {
                changeSt-=1;
                coins++;
            }
        }
        System.out.println(coins);
    }
}
