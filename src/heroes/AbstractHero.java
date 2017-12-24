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
    public String sayName(){
        return name;
    }

    public String getSpecies(){
        return species;
    }

    public int hashCode() {
        HashHandler hash = new HashHandler();
        hash.addStringToHash(name);
        hash.addStringToHash(species);
        return hash.getHash();
    }

    public Dialog startDialog(AbstractHero otherSpeaker, ArrayList<String> dialogText, Weather weather) {
        return new Dialog(this, otherSpeaker, dialogText, weather);
    }

    public boolean equals(AbstractHero other) {
        return name.equals(other.name) && species.equals(other.species);
    }
    protected static class HashHandler {
        int hash = 0;
        final static int p = 31;
        public void  addStringToHash(String string){
            hash = hash * (int)Math.pow(p, string.length()) + string.hashCode();
        }
        public int getHash(){
            return hash;
        }
    }
}
