import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stepsPerDay = scanner.nextLine();
        int totalSteps = 0;
        boolean goalAchieved = false;
        int bonusSteps;
        int currentSteps;
        while (!stepsPerDay.equals("Going home")) {
            currentSteps = Integer.parseInt(stepsPerDay);
            totalSteps += currentSteps;
            if (totalSteps >= 10000) {
                goalAchieved = true;
                break;
            }
            stepsPerDay = scanner.nextLine();
        }
        if (stepsPerDay.equals("Going home")) {
            stepsPerDay = scanner.nextLine();
            currentSteps = Integer.parseInt(stepsPerDay);
            totalSteps += currentSteps;
        }
        if (totalSteps >= 10000) {
            goalAchieved = true;
        }
        if (goalAchieved) {
            bonusSteps = totalSteps - 10000;
            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", bonusSteps);
        }else {
            System.out.printf("%d more steps to reach goal.", 10000 - totalSteps);
        }
    }
}
