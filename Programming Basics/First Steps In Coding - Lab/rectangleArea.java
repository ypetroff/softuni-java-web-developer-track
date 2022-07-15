package com.company;

import java.util.Scanner;

public class SquareArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int SquareArea = a * a;
        System.out.println(SquareArea);
    }
}
