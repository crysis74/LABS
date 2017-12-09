package heroes;

import heroes.Visitor;

public class WalkHero extends Visitor {

    protected WalkHero(String name, String species){
        super(name, species);
    }

    public Visitor getCarrier(){
        return null;
    }


}
