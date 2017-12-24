package heroes;

import events.Action;
import heroes.Visitor;

public class WalkHero extends Visitor implements Actionable {

    public WalkHero(String name, String species){
        super(name, species);
    }

    public Visitor getCarrier(){
        return null;
    }

    public Action performAction(Actions action) {
        return new Action(this, action);
    }

    public boolean equals(WalkHero other){
        return super.equals(other);
    }

    public int hashCode(){
        return super.hashCode();
    }
}
