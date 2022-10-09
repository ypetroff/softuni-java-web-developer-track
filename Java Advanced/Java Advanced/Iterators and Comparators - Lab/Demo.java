
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    private static int pythonLength = 1, pythonRow = 0, pythonCol = 0, foodCount;
    private static boolean gameOver = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int screenLength = Integer.parseInt(reader.readLine());
        String[] commands = reader.readLine().split(", ");

        char[][] screen = populateMatrix(reader, screenLength);

        int commandsCount = commands.length;





            System.out.printf("You win! Final python length is %d", 1);
        }
//            System.out.printf("You lose! There is still %d food to be eaten.", foodCount);





    private static char[][] populateMatrix(BufferedReader reader, int screenLength) throws IOException {

        char[][] matrix = new char[screenLength][screenLength];

        for (int row = 0; row < screenLength; row++) {

            String input = reader.readLine().replaceAll(" ", "");

            matrix[row] = input.toCharArray();

            if (input.contains("s")) {
                pythonRow = row;
                pythonCol = input.indexOf("s");
            }

            if(input.contains("f")) {
                for (char c : input.toCharArray()) {
                    if( c == 'f') {
                        foodCount++;
                    }
                }
            }
        }
        return matrix;
    }

    private static void move(char[][] screen, int addRow, int addCol) {

        screen[pythonRow][pythonCol] = '*';

        boolean inBound = verifyLocation(screen, pythonRow + addRow, pythonCol + addCol);

        if (inBound) {
            pythonRow += addRow;
            pythonCol += addCol;
        }

        if (screen[pythonRow][pythonCol] == 'e') {
            gameOver = true;
        } else if (screen[pythonRow][pythonCol] == 'f') {
            pythonLength++;
            foodCount--;
            screen[pythonRow][pythonCol] = '*';
        }

        screen[pythonRow][pythonCol] = 's';
    }

    private static boolean verifyLocation(char[][] screen, int row, int col) {

        if (row < 0) {
            pythonRow = screen.length - 1;
            return false;
        } else if (row >= screen.length) {
            pythonRow = 0;
            return false;
        }

        if (col < 0) {
            pythonCol = screen[row].length - 1;
            return false;
        } else if (col >= screen[row].length) {
            pythonCol = 0;
            return false;
        }
        return true;
    }

}
