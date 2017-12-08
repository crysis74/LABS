package events;

import heroes.Visitor;
import location.Location;

public class Arrival implements Event {
    private Location location;
    private Visitor visitor;
    private Visitor carrier;

    public Arrival(Location location, Visitor visitor, Visitor carrier){
        this.location = location;
        this.visitor = visitor;
        this.carrier = carrier;
    }

    public String tellStory(){
        if (carrier == null) {
            return visitor.toString() +" сам вошел в " + location.toString();
        }
        else {
            return visitor.toString() + " заносится " + carrier.toString() + " в " + location.toString();
        }
    }
}
