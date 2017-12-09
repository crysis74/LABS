import heroes.Visitor;
import location.Location;
import location.Weather;

public class test {
    public static void main(String[] args) {
        Location location = new Location("Локация 1");
        location.build("Дом", false, Weather.FOG);
        location.build("Сад", true, Weather.DARK);
        System.out.println(location.toString());
    }
}
