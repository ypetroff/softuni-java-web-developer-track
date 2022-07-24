import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cakeLength = Integer.parseInt(scanner.nextLine());
        int cakeWidth = Integer.parseInt(scanner.nextLine());
        int totalSurface = cakeLength * cakeWidth;
        int eatenPieces = 0;
        boolean isEnough = true;
        String pieces = scanner.nextLine();
        while (!pieces.equals("STOP")) {
            int currentPiece = Integer.parseInt(pieces);
            eatenPieces+=currentPiece;
            if (eatenPieces > totalSurface) {
                isEnough = false;
                break;
            }
            if (eatenPieces == totalSurface){
              break;
            }
            pieces = scanner.nextLine();
        }
        if (isEnough) {
            System.out.printf("%d pieces are left.", totalSurface - eatenPieces);
        } else {
            System.out.printf("No more cake left! You need %d pieces more.", eatenPieces - totalSurface);
        }
    }
}
