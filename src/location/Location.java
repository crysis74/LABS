package location;

import java.util.ArrayList;

public class Location {

    private String name;
    private ArrayList<Building> locatoinObjects;
    private int buildingsCount;
    private Weather weather;
    public Location(String name){
        this.name = name;
        buildingsCount = 0;
        locatoinObjects = new ArrayList<>();
    }

    public void build(String name, Boolean state){
        Building building = new Building(name, state);
        locatoinObjects.add(building);
        buildingsCount ++;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("Локация " + name + " содержит: ");
        for(Building building: locatoinObjects){
            result.append(building.toString() + "; ");
        }
        return result.toString();
    }

    private class Building {

        private Building(String name, Boolean state){
            this.name = name;
            this.state=state;
        }

        private String name;
        private Boolean state;
        private Weather weather;
        public String toString(){
            if (state){
                return name;
            }
            else{
                return "разрушенный " + name;
            }
        }
    }
    public int getbuildingsCount(){
        return buildingsCount;
    }
    public void setWeather(Weather newWeather){
        weather = newWeather;
    }

}
