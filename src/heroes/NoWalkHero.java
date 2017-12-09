package heroes;

public class NoWalkHero extends Visitor {
    private String nameCarrier;
    private String speciesCarrier;
    private Visitor carrier;
    public NoWalkHero(String name, String species, String nameCarrier, String speciesCarrier){
        super(name, species);
        this.nameCarrier = nameCarrier;
        this.speciesCarrier = speciesCarrier;
    }
    public void setCarrier(){
        carrier = new WalkHero(nameCarrier,speciesCarrier);
    }
    public Visitor getCarrier() {
        return carrier;
    }

}
