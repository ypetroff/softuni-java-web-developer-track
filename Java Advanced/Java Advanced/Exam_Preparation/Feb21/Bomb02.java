package Feb21;

import java.util.Scanner;

public class Bomb02 {

    public static int sapperRow = 0, sapperCol = 0, bombs = 0;
    private static boolean endOfRoad = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

        char[][] field = populateMatrix(scanner, n);

        for (String command : commands) {

            switch (command) {
                case "up":
                    move(field, -1, 0);
                    break;
                case "down":
                    move(field, 1, 0);
                    break;
                case "left":
                    move(field, 0, -1);
                    break;
                case  "right":
                    move(field, 0, 1);
                    break;
            }

            if(endOfRoad || bombs == 0) {

                String output = endOfRoad
                        ? String.format("END! %d bombs left on the field", bombs)
                        : "Congratulations! You found all bombs!";

                System.out.println(output);
                return;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs, sapperRow, sapperCol);
    }

    private static char[][] populateMatrix(Scanner scanner, int n) {

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {

            String input = scanner.nextLine().replaceAll(" ", "").trim();
            matrix[row] = input.toCharArray();

            if(input.contains("s")) {
                sapperRow = row;
                sapperCol = input.indexOf("s");
            }

            if(input.contains("B")) {

                for (char c : input.toCharArray()) {

                    if(c == 'B') {
                        bombs++;
                    }
                }
            }
        }
        return matrix;
    }

    private static void move(char[][] field, int addRow, int addCol) {

        if(verifyCoordinates(field, sapperRow + addRow, sapperCol + addCol)) {

            field[sapperRow][sapperCol] = '+';

            sapperRow+=addRow;
            sapperCol+=addCol;

            if(field[sapperRow][sapperCol] == 'e') {
                endOfRoad = true;
            } else if(field[sapperRow][sapperCol] == 'B') {
                bombs--;
                System.out.println("You found a bomb!");
            }

            field[sapperRow][sapperCol] = 's';
        }
    }

    private static boolean verifyCoordinates(char[][] field, int row, int col) {
        return row >= 0 && row < field.length && col >= 0 && col < field[row].length;
    }
}
