package events;

import heroes.Visitor;
import location.Location;
import location.Weather;

public class Arrival implements Event {
    private Location location;
    private Visitor visitor;
    private Visitor carrier;
    private Weather weather;

    public Arrival(Location location, Visitor visitor, Visitor carrier, Weather weather){
        this.location = location;
        this.visitor = visitor;
        this.carrier = carrier;
        this.weather = weather;
    }

    public String tellStory(){
        if (carrier == null) {
            return visitor.toString() +" сам зашел на " + location.toString() + " c погодой " + weather;
        }
        else {
            return visitor.toString() + " заносится " + carrier.toString() + " на " + location.toString() + " c погодой " + weather;
        }
    }
}
