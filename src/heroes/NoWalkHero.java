package heroes;

public class NoWalkHero extends Visitor {
    protected NoWalkHero(String name, String species){
        super(name, species);
    }
    public Visitor getCarrier() {
        return new WalkHero("Носильщик","человек");
    }

}
