package Aug21;

import java.util.Scanner;

public class FormulaOne02 {

    private static int playerRow = 0, playerCol = 0;
    private static boolean raceFinish = false, trapOrBonusEffect = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        char[][] racingTrack = populateMatrix(scanner, n);

        while (!raceFinish && numberOfCommands-- > 0) {

            String command = scanner.nextLine();
            switch (command) {

                case "up":
                    move(racingTrack, -1, 0);
                    break;
                case "down":
                    move(racingTrack, 1, 0);
                    break;
                case "left":
                    move(racingTrack, 0, -1);
                    break;
                case "right":
                    move(racingTrack, 0, 1);
                    break;
            }
        }

        if (raceFinish) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(racingTrack);
    }

    private static char[][] populateMatrix(Scanner scanner, int n) {

        char[][] matrix = new char[n][n];

        for (int r = 0; r < n; r++) {

            String input = scanner.nextLine();
            matrix[r] = input.toCharArray();

            if (input.contains("P")) {
                playerRow = r;
                playerCol = input.indexOf("P");
            }
        }
        return matrix;
    }

    private static void move(char[][] racingTrack, int addRow, int addCol) {

        if(!trapOrBonusEffect) {
            racingTrack[playerRow][playerCol] = '.';

        }



       boolean hasCrossed =  verifyCoordinates(racingTrack, playerRow + addRow, playerCol + addCol);

       if(!hasCrossed) {
           playerRow+=addRow;
           playerCol+=addCol;
       }

       if(racingTrack[playerRow][playerCol] == 'F') {
           raceFinish = true;
       }else if(racingTrack[playerRow][playerCol] == 'B') {
           trapOrBonusEffect = true;
           move(racingTrack, addRow, addCol);

       }else if(racingTrack[playerRow][playerCol] == 'T') {
           trapOrBonusEffect = true;
           move(racingTrack, -addRow, -addCol);
       }
       racingTrack[playerRow][playerCol] = 'P';
       trapOrBonusEffect = false;




    }

    private static boolean verifyCoordinates(char[][] racingTrack, int newRow, int newCol) {
        if (newRow < 0) {
            playerRow = racingTrack.length - 1;
            return true;
        } else if (newRow >= racingTrack.length) {
            playerRow = 0;
            return true;
        }

        if (newCol < 0) {
            playerCol = racingTrack[newRow].length - 1;
            return true;
        } else if (newCol >= racingTrack[newRow].length) {
            playerCol = 0;
            return true;
        }
        return false;
    }

    private static void printMatrix(char[][] racingTrack) {

        for (char[] chars : racingTrack) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
