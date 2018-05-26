import Mistakes.AbstractHeroException;
import heroes.Actions;
import heroes.Inhabitant;
import heroes.NoWalkHero;
import heroes.WalkHero;
import location.Location;
import location.Weather;

import java.util.ArrayList;

public class Test {
    static ArrayList<Location> location = new ArrayList<>();
    static String file;

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                Interactive save = new Interactive();
                save.save(file);
            }
        });
        try {

            file = System.getenv("kek");

            location.add(new Location("Cказочный лес"));
            FileKrugets open = new FileKrugets(file);
            open.fileread();

            System.out.println(location.get(0).getLocationObjects().size());

            location.get(0).setWeather(Weather.FOG);
            Inhabitant inhabitant = new Inhabitant(" Муми-дол", "Тролль");
            location.get(0).setInhabitant(inhabitant);
            WalkHero snork = new WalkHero("Снорк", "Человек");
            WalkHero mymi = new WalkHero("Муми-тролль", "Тролль");
            NoWalkHero pantaloshka = new NoWalkHero("Панталошка", "Монстр", mymi) {
                public String toString() {
                    return "Монстр по имени " + getClass().getName() + " расы " + species + " с большой пастью и тяжелейшей тушой";
                }
            };
            System.out.println(snork.visit(location.get(0)).tellStory());
            System.out.println(mymi.visit(location.get(0)).tellStory());
            System.out.println(new NoWalkHero("Панталошка", "Монстр", mymi).visit(location.get(0)).tellStory());
            System.out.println(mymi.visitBuilding(location.get(0), "Дом").tellStory());
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
            Interactive interactive = new Interactive();
            new Thread(() -> {
                while(true) {
                    interactive.save(file);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


            interactive.start();

        }
        catch (AbstractHeroException ex){
            System.out.println(ex);
        }

    }

}
