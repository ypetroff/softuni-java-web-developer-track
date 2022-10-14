package TrafficLights04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lights = scanner.nextLine().split("\\s+"); //or stream map(Colour::valueOf).toArray(Colour[] new)

       List<TrafficLight> trafficLightArrayList = new ArrayList<>();

        for (String light : lights) {


            TrafficLight trafficLight = new TrafficLight(Colour.valueOf(light));
            trafficLightArrayList.add(trafficLight);

        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            for (TrafficLight trafficLight : trafficLightArrayList) {
                trafficLight.changeColour();
            }
            System.out.println();

        }
    }
}
