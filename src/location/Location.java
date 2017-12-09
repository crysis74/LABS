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

    public void build(String name, Boolean state, Weather weather){
        Building building = new Building(name, state, weather);
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

        private Building(String name, Boolean state, Weather weather){
            this.name = name;
            this.state=state;
            this.weather=weather;
        }

        private String name;
        private Boolean state;
        private Weather weather;
        public String toString(){
            if (state){
                return name + " с " + weather + " погодой";
            }
            else{
                return "разрушенный " + name + " с " + weather + " погодой";
            }
        }
    }
    public int getbuildingsCount(){
        return buildingsCount;
    }
}
