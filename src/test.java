import location.Location;

public class test {
    public static void main(String[] args) {
        Location location = new Location("Локация 1");
        location.build("Дом", false);
        location.build("Сад", true);
        System.out.println(location);
    }
}
