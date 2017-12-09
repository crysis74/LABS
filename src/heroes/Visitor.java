package heroes;

import events.Arrival;
import location.Location;
import location.Weather;

public abstract class Visitor extends AbstractHero {

    private Weather weather;
    protected Visitor(String name, String species){
        super(name, species);
    }
    public Arrival visit(Location location){
        return new Arrival(location, this, getCarrier(), location.setWeather());
    }

    public abstract Visitor getCarrier();

    public String toString(){
        return "Путешенственник по имени " + name + " расы " + species;
    }
}
