package PointInRectangle02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] coordinates = readArr(reader);
        // x and y for each point
        Point pointA = new Point(coordinates[0], coordinates[1]);
        Point pointC = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(pointA, pointC);

        int pointsToCheck = Integer.parseInt(reader.readLine());

        while (pointsToCheck-- > 0) {
            int[] pointCoordinates = readArr(reader);
            Point p = new Point(pointCoordinates[0], pointCoordinates[1]);

            System.out.println(rectangle.isInBound(p));
        }
    }

    private static int[] readArr(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
