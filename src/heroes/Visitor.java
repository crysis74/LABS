package heroes;

import events.Arrival;
import events.Visit;
import location.Location;

public abstract class Visitor extends AbstractHero {

    protected Visitor(String name, String species){
        super(name, species);
    }
    public Arrival visit(Location location){
        return new Arrival(location, this, getCarrier(), location.setWeather());
    }
    public Visit visitBuilding(Location location, int number){
        return new Visit(location, number, this, getCarrier());
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
