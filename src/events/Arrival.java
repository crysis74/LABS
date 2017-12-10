package events;

import heroes.Visitor;
import location.Location;
import location.Weather;

public class Arrival implements Event {
    private Location location;
    private Visitor visitor;
    private Visitor carrier;
    private Weather weather;
    private Boolean skared;

    public Arrival(Location location, Visitor visitor, Visitor carrier, Weather weather){
        this.location = location;
        this.visitor = visitor;
        this.carrier = carrier;
        this.weather = weather;
        skared = location.getBuildingsCount() < location.getDestroyedBildings() * 2;
    }

    public String tellStory(){
        //TODO - scared
        if (carrier == null) {
            return visitor.toString() +" сам зашел на " + location.toString() + " . Погода здесь была " + weather;
        }
        else {
            return visitor.toString() + " заносится " + carrier.toString() + " на " + location.toString() + " . Погода здесь была " + weather;
        }

    }
}
