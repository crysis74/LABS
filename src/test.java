import heroes.*;
import location.Location;
import location.Weather;

import java.util.ArrayList;

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
        ArrayList<String> dialog = new ArrayList<>();
        dialog.add("ривет");
        dialog.add("как дела ваще");
        dialog.add("нормик, ы))");
        System.out.println(snork.startDialog(mymi, dialog, Weather.FOG).tellStory());
        System.out.println(((Actionable)snork).performAction(Actions.JUMP).tellStory());
    }
}
