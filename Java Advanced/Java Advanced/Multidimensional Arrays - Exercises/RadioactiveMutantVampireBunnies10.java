import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] layer = initiateLayer(rows, cols, scanner);
        char[] commands = scanner.nextLine().toCharArray();
        int[] playerLocation = locatePlayer(layer);
        boolean playerWon = false;
        boolean bunniesWon = false;
        for (char command : commands) {
            switch (command) {
                case 'U':
                    int goUp = playerLocation[0] - 1;
                    playerWon = checkWinningCondition(layer, goUp, playerLocation[1]);
                    if(!playerWon) {
                        bunniesWon = movePlayerUpOrDown(layer, playerLocation[0], playerLocation[1], goUp);
                        playerLocation[0] = goUp;
                        if(bunniesWon) {
                            break;
                        }
                    }
                    break;
                case 'D':
                    int goDown = playerLocation[0] + 1;
                    playerWon = checkWinningCondition(layer,goDown, playerLocation[1]);
                    if(!playerWon) {
                        bunniesWon = movePlayerUpOrDown(layer, playerLocation[0], playerLocation[1], goDown);
                        playerLocation[0] = goDown;
                        if(bunniesWon) {
                            break;
                        }
                    }
                    break;
                case 'L':
                    int goLeft = playerLocation[1] - 1;
                    playerWon = checkWinningCondition(layer, playerLocation[0], goLeft);
                    if(!playerWon) {
                        bunniesWon = movePlayerLeftOrRight(layer, playerLocation[0], playerLocation[1], goLeft);
                        playerLocation[1] = goLeft;
                        if(bunniesWon) {
                            break;
                        }
                    }
                    break;
                case 'R':
                    int goRight = playerLocation[1] + 1;
                    playerWon = checkWinningCondition(layer, playerLocation[0], goRight);
                    if(!playerWon) {
                        bunniesWon = movePlayerLeftOrRight(layer, playerLocation[0], playerLocation[1], goRight);
                        playerLocation[1] = goRight;
                        if(bunniesWon) {
                            break;
                        }
                    }
                    break;
            }
            if(playerWon) {
                layer[playerLocation[0]][playerLocation[1]] = '.';
            }
            bunniesWon = multiplyBunnies(layer);
            if (bunniesWon || playerWon) {
                break;
            }
        }

        printLayer(layer);
        if(bunniesWon) {
            System.out.printf("dead: %d %d", playerLocation[0], playerLocation[1]);
        }else {
            System.out.printf("won: %d %d", playerLocation[0], playerLocation[1]);
        }
    }




    private static char[][] initiateLayer(int rows, int cols, Scanner scanner) {
        char[][]layer = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            layer[row] = scanner.nextLine().toCharArray();
        }
        return layer;
    }

    private static int[] locatePlayer(char[][] layer) {
        int[] coordinates = new int[2];

        for (int row = 0; row < layer.length; row++) {
            for (int col = 0; col < layer[row].length; col++) {
                if(layer[row][col] == 'P') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }

    private static boolean checkWinningCondition(char[][] layer, int row, int col) {
        return row < 0 || row >= layer.length || col < 0 || col >= layer[row].length;
    }

    private static boolean movePlayerUpOrDown(char[][] layer, int row, int col, int newRow) {
        if(layer[newRow][col] == 'B') {
            return true;
        }
        layer[row][col] = '.';
        layer[newRow][col] = 'P';

        return false;
    }

    private static boolean movePlayerLeftOrRight(char[][] layer, int row, int col, int newCol) {
        if(layer[row][newCol] == 'B') {
            return true;
        }
        layer[row][col] = '.';
        layer[row][newCol] = 'P';

        return false;
    }

    private static boolean multiplyBunnies(char[][] layer) {
        List<List<Integer>> originalBunnies = findOriginalBunnies(layer);
        boolean isDead = false;

        for (List<Integer> bunny : originalBunnies) {
            int row = bunny.get(0);
            int col = bunny.get(1);

            if(row - 1 >= 0 && layer[row - 1][col] != 'B') {
                if(layer[row - 1][col] == 'P') {
                    layer[row - 1][col] = 'B';
                    isDead = true;
                }else {
                    layer[row - 1][col] = 'B';
                }
            }
            if(row + 1 < layer.length && layer[row + 1][col] != 'B') {
                if(layer[row + 1][col] == 'P') {
                    layer[row + 1][col] = 'B';
                    isDead = true;
                }else {
                    layer[row + 1][col] = 'B';
                }
            }
            if(col - 1 >= 0 && layer[row][col - 1] != 'B') {
                if(layer[row][col - 1] == 'P') {
                    layer[row][col - 1] = 'B';
                    isDead = true;
                }else {
                    layer[row][col - 1] = 'B';
                }
            }
            if(col + 1 < layer[row].length && layer[row][col + 1] != 'B') {
                if(layer[row][col + 1] == 'P') {
                    layer[row][col + 1] = 'B';
                    isDead = true;
                }else {
                    layer[row][col + 1] = 'B';
                }
            }
        }
        return isDead;
    }

    private static List<List<Integer>> findOriginalBunnies(char[][] layer) {
        List<List<Integer>> originalBunniesCells = new ArrayList<>();
        for (int row = 0; row < layer.length; row++) {
            for (int col = 0; col < layer[row].length; col++) {
                if(layer[row][col] == 'B') {
                    originalBunniesCells.add(Arrays.asList(row, col));
                }
            }
        }
        return originalBunniesCells;
    }

    private static void printLayer(char[][] layer) {
        for (char[] chars : layer) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
