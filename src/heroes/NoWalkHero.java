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

}
