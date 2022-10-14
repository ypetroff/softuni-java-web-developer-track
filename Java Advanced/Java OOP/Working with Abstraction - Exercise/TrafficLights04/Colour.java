package TrafficLights04;

public enum Colour {
    RED,
    GREEN,
    YELLOW;

    public Colour nextLight(int index){
        if(index < 2) {                     ///or switch
            return Colour.values()[++index];
        }
        return  Colour.values()[0];
    }
}
