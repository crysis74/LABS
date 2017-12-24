package Mistakes;

import location.Location;

public class DestroyedBuildingException extends RuntimeException {
    private Location location;
    private int number;
    public DestroyedBuildingException(Location location, int number){
        this.location = location;
        this.number = number;
    }
    public String toString(){
        return "Ошибка входа в " + location.getBuildingName(number);
    }
}
