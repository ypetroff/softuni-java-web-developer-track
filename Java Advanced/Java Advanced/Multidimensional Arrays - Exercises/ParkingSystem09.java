import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        boolean[][] parkingLot = prepareTheLot(rows, cols);
      //  boolean[][] parkingLot = new boolean[rows][cols];
        String command;
        while (!"stop".equals(command = scanner.nextLine())) {
            int[] coordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entrypointRow = coordinates[0];
            int row = coordinates[1];
            int col = coordinates[2];
            int carCell;

           boolean freeRow = freeRow(parkingLot[row]);
           if(!freeRow) {
               System.out.printf("Row %d full%n", row);
           }else {
               int radius = 1;
               carCell = parkTheCar(parkingLot[row], col, radius);
               int distance = Math.abs(entrypointRow - row) +carCell + 1;
               System.out.println(distance);
           }
        }
    }



    private static boolean[][] prepareTheLot(int rows, int cols) {
        boolean[][] parkingLot = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            parkingLot[row][0] = true;
        }
        return parkingLot;
    }

    private static boolean freeRow(boolean[] row) {
        for (boolean b : row) {
            if(!b) {
                return true;
            }
        }
        return false;
    }

    private static int parkTheCar(boolean[] booleans, int col, int radius) {
        int output;


        if(!booleans[col]) {
            booleans[col] = true;
            output = col;
        } else if(col - radius > 0 && !booleans[col - radius]) {
            booleans[col - radius] = true;
            output = col - radius;
        }else if(col + radius < booleans.length && !booleans[col + radius]) {
            booleans[col + radius] = true;
           output = col +radius;
        }else {
            radius++;
           output = parkTheCar(booleans, col, radius);
        }
        return  output;
    }


}
