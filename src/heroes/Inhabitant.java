package heroes;

public class Inhabitant extends AbstractHero implements Actionable {

    public Inhabitant(String name, String species){
        super(name, species);
    }
    public String toString(){
        return " . Обитатель этого места " + name + " рассы " + species;
    }

}
