package event;

import heroes.Visitor;
import location.Location;

public class Arrival implements Event {
    private Location location;
    private Visitor visitor;

    public Arrival(Location location, Visitor visitor){
        this.location = location;
        this.visitor = visitor;
    }
}
