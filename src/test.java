import heroes.Inhabitant;
import heroes.NoWalkHero;
import heroes.Visitor;
import heroes.WalkHero;
import location.Location;
import location.Weather;

public class test {
    public static void main(String[] args) {
        Location location = new Location("новую локация");
        location.build("Дом", false);
        location.build("Сад", true);
        location.setWeather(Weather.FOG);
        Inhabitant inhabitant = new Inhabitant("Мирный житель", "человек");
        location.setInhabitant(inhabitant);
        Visitor snork = new WalkHero("Снорк", "Человек");
        Visitor mymi = new WalkHero("Муми-тролль", "Тролль");
        Visitor pantaloshka = new NoWalkHero("Панталошка", "Монстр", mymi);
        System.out.println(snork.visit(location).tellStory());
        System.out.println(mymi.visit(location).tellStory());
        System.out.println(pantaloshka.visit(location).tellStory());

    }
}
