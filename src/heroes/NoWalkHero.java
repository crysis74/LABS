package heroes;

public class NoWalkHero extends Visitor {
    private Visitor carrier;
    public NoWalkHero(String name, String species, Visitor carrier){
        super(name, species);
        this.carrier = carrier;
    }

    public Visitor getCarrier() {
        return carrier;
    }

    public boolean equals(NoWalkHero other) {
        return super.equals(other) && carrier.equals(other.carrier);
    }
    public int hashcode(){
        return super.hashCode() * (int)Math.pow(31, carrier.name.length() + carrier.species.length()) +  carrier.hashCode();
    }
}
