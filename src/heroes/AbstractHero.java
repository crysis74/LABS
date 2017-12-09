package heroes;

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
}
