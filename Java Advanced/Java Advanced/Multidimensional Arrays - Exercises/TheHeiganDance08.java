import java.util.Scanner;

public class TheHeiganDance08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heiganHP = 3000000;
        int playerHP = 18500;
        int playerCurrentRow = 7;
        int playerCurrentCol = 7;
        double damage = Double.parseDouble(scanner.nextLine());
        String prevSpell = "", spell = "";
        boolean cloudSuccessfullyCast = false;

        while(playerHP > 0 && heiganHP > 0) {
            heiganHP-=damage;
            if(cloudSuccessfullyCast) {
                playerHP-=3500;
                cloudSuccessfullyCast = false;
            }

            if(playerHP <= 0 || heiganHP <= 0 ) {
                break;
            }
            String[] input = scanner.nextLine().split("\\s+");
            spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            boolean[][]matrix = new boolean[15][15];
            for (int r = row - 1; r <=row + 1; r++) {
                if(validateRow(matrix, r)) {
                    for (int c = col - 1; c <= col + 1; c++) {
                        if(validateCol(matrix, r, c)) {
                            matrix[r][c] = true;
                        }
                    }
                }
            }

            if(matrix[playerCurrentRow][playerCurrentCol]) {
                if(validateRow(matrix, playerCurrentRow - 1) && !matrix[playerCurrentRow - 1][playerCurrentCol]) {
                    playerCurrentRow--;
                } else if (validateCol(matrix, playerCurrentRow, playerCurrentCol + 1) && !matrix[playerCurrentRow][playerCurrentCol + 1]) {
                    playerCurrentCol++;
                } else if(validateRow(matrix, playerCurrentRow + 1) && !matrix[playerCurrentRow + 1][playerCurrentCol]) {
                    playerCurrentRow++;
                }else if(validateCol(matrix, playerCurrentRow, playerCurrentCol - 1) && !matrix[playerCurrentRow][playerCurrentCol - 1]) {
                    playerCurrentCol--;
                }

                if(matrix[playerCurrentRow][playerCurrentCol]) {
                    switch (spell) {
                        case "Cloud":
                            playerHP-=3500;
                            cloudSuccessfullyCast = true;
                            break;
                        case "Eruption":
                            playerHP-=6000;
                            break;
                    }
                }
            }

        }

        if (heiganHP <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHP);
        }

        if (playerHP <= 0) {
            if(spell.equals("Cloud")) {
                spell = "Plague Cloud";
            }
            System.out.printf("Player: Killed by %s%n", spell);
        } else {
            System.out.printf("Player: %d%n", playerHP);
        }

        System.out.printf("Final position: %d, %d%n",playerCurrentRow, playerCurrentCol);

    }



    private static boolean validateRow(boolean[][] matrix, int row) {
        return row < matrix.length && row >= 0;
    }

    private static boolean validateCol(boolean[][] matrix, int row, int col) {
        return col <matrix[row].length && col>= 0;
    }
}
