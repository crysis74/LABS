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
        StringBuilder arrival = new StringBuilder();
        if (carrier == null) {
            arrival.append(visitor.toString() +" сам зашел на " + location.toString() + " . Погода здесь была " + weather + ". ");
        }
        else {
            arrival.append(visitor.toString() + " заносится " + carrier.toString() + " на " + location.toString() +
                    " . Погода здесь была " + weather + ". ");
        }
        if(skared){
            arrival.append(visitor.sayName() + " был очень испуган, ведь это место было практически полностью разрушено.");
        }
        else {
            arrival.append(visitor.sayName() + " чувствовал себя уверенно, ведь это место внушало доверие");
        }
        return arrival.toString();
    }
    public String toString(){
        return visitor.sayName() + " находиться на " + location.toString();
    }
}
