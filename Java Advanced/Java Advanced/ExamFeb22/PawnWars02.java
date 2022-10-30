import java.util.Scanner;

public class PawnWars02 {

    private static final int BOARD_DIMENSION = 8, WHITE_FINISH = 0, BLACK_FINISH = 7;

    private static int whitePawnRow = 0, whitePawnCol = 0, blackPawnRow = 0, blackPawnCol = 0;
    private static char[][] board;
    private static final  char[] boardLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private static boolean whiteFinished = false, blackFinished = false, whiteCapture = false, blackCapture = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        populateMatrix(scanner);

        while (!whiteFinished && !blackFinished && !whiteCapture && !blackCapture) {

            move(WHITE_FINISH, -1);

            if (!whiteFinished && !blackFinished && !whiteCapture && !blackCapture) {
                move(BLACK_FINISH, 1);
            }
        }


        String coordinates;
        String winner;

        if (whiteFinished || blackFinished) {

            winner = getWinner(whiteFinished);

            coordinates = getCoordinates(winner);

            System.out.printf("Game over! %s pawn is promoted to a queen at %s.",
                    winner, coordinates);
        }

        if (whiteCapture || blackCapture) {

            winner = getWinner(whiteCapture);

            coordinates = getCoordinates(winner);

            System.out.printf("Game over! %s capture on %s.", winner, coordinates);

        }
    }

    private static void populateMatrix(Scanner scanner) {
        board = new char[BOARD_DIMENSION][BOARD_DIMENSION];

        for (int row = 0; row < BOARD_DIMENSION; row++) {

            String input = scanner.nextLine();
            board[row] = input.toCharArray();

            if(input.contains("w")) {
                whitePawnRow = row;
                whitePawnCol = input.indexOf('w');
            }

            if(input.contains("b")) {
                blackPawnRow = row;
                blackPawnCol = input.indexOf('b');
            }
        }
    }

    private static void move(int finish, int addRow) {
        int row, col;

        if(finish == WHITE_FINISH) {
            row = whitePawnRow;
            col = whitePawnCol;
        } else {
            row = blackPawnRow;
            col = blackPawnCol;
        }

        board[row][col] = '-';

        if((whitePawnCol == blackPawnCol - 1 || whitePawnCol == blackPawnCol + 1) &&
        whitePawnRow == blackPawnRow + 1) {

            if(finish == WHITE_FINISH) {
                whitePawnRow = blackPawnRow;
                whitePawnCol = blackPawnCol;
                board[whitePawnRow][whitePawnCol] = 'w';
                whiteCapture = true;
            } else {
                board[whitePawnRow][whitePawnCol] = 'b';
                blackPawnRow = whitePawnRow;
                blackPawnCol = whitePawnCol;
                blackCapture = true;
            }
        } else {
            row+=addRow;
            board[row][col] = finish == WHITE_FINISH
                    ? 'w'
                    : 'b';

            if(!whiteCapture && !blackCapture) {
                if(finish == WHITE_FINISH) {
                    whitePawnRow = row;
                }else {
                    blackPawnRow = row;
                }
            }


        }

        if(whitePawnRow == WHITE_FINISH) {
            whiteFinished = true;
        } else if(blackPawnRow == BLACK_FINISH) {
            blackFinished = true;
        }

    }

    private static String getWinner(boolean bool) {
        return bool
                ? "White"
                : "Black";
    }

    private static String getCoordinates(String winner) {
        String coordinates;
        char col;

        if (winner.equals("White")) {

            col = boardLetters[whitePawnCol];
            coordinates = col + String.valueOf(BLACK_FINISH - whitePawnRow + 1);
        } else {
            col = boardLetters[blackPawnCol];
            coordinates = col + String.valueOf(BLACK_FINISH - blackPawnRow + 1);
        }
        return coordinates;
    }
}
