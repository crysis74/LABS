package heroes;

import events.Arrival;
import location.Location;
import location.Weather;

public abstract class Visitor extends AbstractHero {

    protected Visitor(String name, String species){
        super(name, species);
    }
    public Arrival visit(Location location){
        return new Arrival(location, this, getCarrier(), location.setWeather());
    }

    public abstract Visitor getCarrier();
    public boolean equals(Visitor other){
        return super.equals(other);
    }
    public String toString(){
        return "Путешенственник по имени " + name + " расы " + species;
    }
    public int hashCode(){
        return super.hashCode();
    }
}
