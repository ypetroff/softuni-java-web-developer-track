package com.company;

import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int projects = Integer.parseInt(scanner.nextLine());
        int time = projects * 3;
        System.out.printf("The architect %s will need %s hours to complete %s project/s.", name, time, projects);

    }
}
