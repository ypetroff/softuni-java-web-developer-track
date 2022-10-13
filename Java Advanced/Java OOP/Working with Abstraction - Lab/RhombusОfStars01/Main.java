package RhombusОfStars01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

         printRhombus(n);
    }

    private static void printRhombus(int n) {


            printTop(n);
            printMiddle(n);
            printBottom(n);


    }

    private static void printTop(int n) {
        for (int i = 1; i < n; i++) {
            printRow(n - i, " ");
            printRow(i, "* ");
            System.out.println();
        }
    }

    private static void printMiddle(int n) {
        printRow(n, "* ");
        System.out.println();
    }

    private static void printBottom(int n) {
        for (int i = 1; i < n; i++) {
            printRow(i, " ");
            printRow(n - i, "* ");
            System.out.println();
        }

    }

    private static void printRow(int n, String s) {
        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
    }
}
