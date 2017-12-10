package heroes;

import events.Action;

public class Inhabitant extends AbstractHero implements Actionable {

    public Inhabitant(String name, String species){
        super(name, species);
    }
    public String toString(){
        return " . Обитатель этого места " + name + " расы " + species;
    }
    public Action performAction(Actions action){
        return new Action(this, action);
    }

    public boolean equals(Inhabitant other) {
        return super.equals(other);
    }

}
