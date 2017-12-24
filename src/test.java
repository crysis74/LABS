import Mistakes.AbstractHeroException;
import heroes.*;
import location.Location;
import location.Weather;

import java.util.ArrayList;
import java.util.concurrent.AbstractExecutorService;

public class test {
    public static void main(String[] args) {
        try {
            Location location = new Location("Cказочный лес");
            location.build("Дом", false);
            location.build("Сад", true);
            location.setWeather(Weather.FOG);
            Inhabitant inhabitant = new Inhabitant(" Муми-дол", "Тролль");
            location.setInhabitant(inhabitant);
            WalkHero snork = new WalkHero("Снорк", "Человек");
            WalkHero mymi = new WalkHero("Муми-тролль", "Тролль");
            NoWalkHero pantaloshka = new NoWalkHero("Панталошка", "Монстр", mymi) {
                public String toString() {
                    return "Монстр по имени " + name + " расы " + species + " с большой пастью и тяжелейшей тушой";
                }
            };
            System.out.println(snork.visit(location).tellStory());
            System.out.println(mymi.visit(location).tellStory());
            System.out.println(pantaloshka.visit(location).tellStory());
            System.out.println(mymi.visitBuilding(location, 0).tellStory());
            ArrayList<String> dialog1 = new ArrayList<>();
            dialog1.add("Что мы здесь забыли?");
            dialog1.add("Я сам не знаю.");
            dialog1.add("Надо уходить отсюда.");
            System.out.println(snork.startDialog(mymi, dialog1, Weather.FOG).tellStory());
            System.out.println(snork.performAction(Actions.JUMP).tellStory());
            System.out.println(mymi.performAction(Actions.WATCH).tellStory());
            ArrayList<String> dialog2 = new ArrayList<>();
            dialog2.add("Что-то мы находились за сегодня, может мы пойдем домой?");
            dialog2.add("Отличная идея.");
            System.out.println(mymi.startDialog(pantaloshka, dialog2, Weather.DARK).tellStory());
            System.out.println("Герои решили, что приклюений на сегодня достаточно, поэтому они решили завершить свое путешествие...");
        }
        catch (AbstractHeroException ex){
            System.out.println(ex);
        }

    }
}
