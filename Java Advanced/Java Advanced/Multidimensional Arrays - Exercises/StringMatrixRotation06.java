import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([0-9]+)");
        Matcher matcher = pattern.matcher(input);

        int rotations = 0;
        while (matcher.find()) {
            rotations = Integer.parseInt(matcher.group(1)) / 90;
        }

        List<String> text = getStrings(scanner);

        int cols = text.stream().max(Comparator.comparingInt(String::length)).get().length();
        int rows = text.size();

        char[][] matrix = populateMatrix(text, rows, cols);

        char[][] rotatedMatrix = rotateMatrix(matrix, rotations);
        printMatrix(rotatedMatrix);

    }

    private static List<String> getStrings(Scanner scanner) {
        List<String> text = new ArrayList<>();

        String input;

        while (!"END".equals(input = scanner.nextLine())) {
            text.add(input);
        }
        return text;
    }

    private static char[][] populateMatrix(List<String> text, int size, int maxLength) {
        char[][] matrix = new char[size][maxLength];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = getLine(text, maxLength);
        }
        return matrix;
    }

    private static char[] getLine(List<String> text, int length) {
        List<Character> listOfChars = new ArrayList<>();
        char[] arr = text.get(0).toCharArray();
        for (char c : arr) {
            listOfChars.add(c);
        }
        text.remove(0);

        while (listOfChars.size() < length) {
            listOfChars.add(' ');
        }

        String output = useStringBuilder(listOfChars);

        return output.toCharArray();
    }

    private static String useStringBuilder(List<Character> listOfChars) {
        StringBuilder sb = new StringBuilder();
        for (Character aChar : listOfChars) {
            sb.append(aChar);
        }
        return sb.toString();
    }

    private static char[][] rotateMatrix(char[][] matrix, int rotations) {
        char[][] rotatedMatrix = new char[matrix[0].length][matrix.length];

        if(rotations == 0) {
            return matrix;
        }
        int currentCol = 0;
        for (int rows = 0; rows < rotatedMatrix.length; rows++) {
            for (int cols = 0; cols < rotatedMatrix[0].length; cols++) {
                rotatedMatrix[rows][cols] = matrix[matrix.length - 1 - cols][currentCol];
            }
            currentCol++;
        }




        rotations--;
        return rotateMatrix(rotatedMatrix, rotations);
    }


    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
