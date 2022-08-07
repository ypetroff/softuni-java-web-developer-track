import java.util.Scanner;

public class Snowballs11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int snowBalls = Integer.parseInt(scanner.nextLine());
        long snowballValue = 0;
        int snowballSnow, snowballTime, snowballQuality, quality = 0, snow = 0, time = 0;

        for (int i = 0; i < snowBalls; i++) {
            snowballSnow = Integer.parseInt(scanner.nextLine());
            snowballTime = Integer.parseInt(scanner.nextLine());
            snowballQuality = Integer.parseInt(scanner.nextLine());


            double currentBallValue = Math.pow(((double) snowballSnow / snowballTime), snowballQuality);

            if (currentBallValue > snowballValue) {

                snowballValue = (long)currentBallValue;
                quality = snowballQuality;
                snow = snowballSnow;
                time = snowballTime;
            }

        }

        System.out.printf("%d : %d = %d (%d)", snow, time, snowballValue, quality);


    }
}
