package TrafficLights04;

public class TrafficLight {

    private Colour colour;

    public TrafficLight(Colour colour) {
        this.colour = colour;
    }

    public void changeColour() {
        colour = colour.nextLight(colour.ordinal());
        System.out.print(colour + " ");
    }
}
