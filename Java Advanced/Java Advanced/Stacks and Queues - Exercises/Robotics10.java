import java.util.*;

public class Robotics10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsInfo = scanner.nextLine().split(";");

        Map<String, List<Integer>> robots = new LinkedHashMap<>();
        for (String s : robotsInfo) {
            robots.put(s.split("-")[0], Arrays.asList(Integer.parseInt(s.split("-")[1]), 0));
        }
        String timeInput = scanner.nextLine();
        String[] time = timeInput.split(":");
        int timeNow = (Integer.parseInt(time[0]) * 3600) + (Integer.parseInt(time[1]) * 60) + Integer.parseInt(time[2]);


        ArrayDeque<String> queue = new ArrayDeque<>();

        String product;
        while (!"End".equals(product = scanner.nextLine())) {

            timeNow++;

            String currentRobot = findRobot(robots);

            if(currentRobot.equals("no free robots")) {
                queue.offer(product);
            } else {
                robotStartsWork(currentRobot, product, convertTime(timeNow), robots);
            }

            reduceTime(robots);
        }

        while (!queue.isEmpty()) {
            timeNow++;

            String currentRobot = findRobot(robots);

            if(!currentRobot.equals("no free robots")) {
                product = queue.poll();
                robotStartsWork(currentRobot, product, convertTime(timeNow), robots);
            }else {
                queue.offer(queue.poll());
            }

            reduceTime(robots);
        }

    }

    private static String findRobot(Map<String, List<Integer>> robots) {
        String currentRobot = "no free robots";
        for (Map.Entry<String, List<Integer>> entry : robots.entrySet()) {
            if (entry.getValue().get(1) == 0) {
                currentRobot = entry.getKey();
                break;
            }
        }
        return currentRobot;
    }

    private static void robotStartsWork(String currentRobot, String product, String timeNow, Map<String, List<Integer>> robots) {


            System.out.printf("%s - %s %s%n", currentRobot, product, timeNow);
            robots.put(currentRobot, Arrays.asList(robots.get(currentRobot).get(0), robots.get(currentRobot).get(0)));

    }

    private static void reduceTime(Map<String, List<Integer>> robots) {
        robots.entrySet().stream().filter(r -> r.getValue().get(1) > 0)
                .forEach(r -> r.getValue().set(1, r.getValue().get(1) - 1));
    }

    private static String convertTime(int timeNow) {
        return String.format("[%02d:%02d:%02d]", (timeNow / 3600) % 24, (timeNow / 60) % 60, timeNow % 60);
    }
}
