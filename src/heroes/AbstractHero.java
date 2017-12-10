package heroes;

import events.Dialog;
import location.Weather;

import java.util.ArrayList;

public abstract class AbstractHero {
    protected String name;
    protected String species;

    protected AbstractHero(String name, String species){
        this.name = name;
        this.species = species;
    }
   /* public Dialog speak () {
        return new Dialog();
    }*/
    public String sayName(){
        return name;
    }

    public String getSpecies(){
        return species;
    }

    public int hashCode() {
        return name.hashCode() * (int)Math.pow(31, species.length()) + species.hashCode();
    }

    public Dialog startDialog(AbstractHero otherSpeaker, ArrayList<String> dialogText, Weather weather) {
        return new Dialog(this, otherSpeaker, dialogText, weather);
    }

    public boolean equals(AbstractHero other) {
        return name.equals(other.name) && species.equals(other.species);
    }
}
