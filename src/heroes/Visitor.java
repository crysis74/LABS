package heroes;

import events.Arrival;
import location.Location;

public abstract class Visitor extends AbstractHero {

    protected Visitor(String name, String species){
        super(name, species);
    }
    public Arrival visit(Location location){
        return new Arrival(location, this, getCarrier());
    }

    public abstract Visitor getCarrier();

    public String toString(){
        return "Путешенственник по имени " + name + " расы " + species;
    }
}
