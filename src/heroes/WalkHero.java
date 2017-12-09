package heroes;

import heroes.Visitor;

public class WalkHero extends Visitor implements Actionable {

    public WalkHero(String name, String species){
        super(name, species);
    }

    public Visitor getCarrier(){
        return null;
    }



}
