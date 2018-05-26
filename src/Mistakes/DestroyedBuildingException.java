package Mistakes;

import location.Location;

public class DestroyedBuildingException extends Exception {
    private Location location;
    private String name;
    public DestroyedBuildingException(Location location, String name){
        this.location = location;
        this.name = name;
    }
    public String toString(){
        return "Ошибка входа в " + location.getBuildingName(name);

    }
}
