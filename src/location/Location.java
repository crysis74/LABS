package location;

import heroes.Inhabitant;

import java.util.Collections;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class Location implements Comparable<Location>{

    private String name;
    private TreeSet<Building> locatoinObjects;
    private int destroyedBildings;
    private int buildingsCount;
    private Weather weather;
    private Inhabitant inhabitant;
    public Location(String name){
        this.name = name;
        destroyedBildings = 0;
        buildingsCount = 0;
        inhabitant = null;
        locatoinObjects = new TreeSet<>();
    }
    public TreeSet<Building> getLocationObjects(){
        return locatoinObjects;
    }
    public void setInhabitant(Inhabitant newinhabitant){
        inhabitant = newinhabitant;
    }
    public Inhabitant getInhabitant(){
        return inhabitant;
    }
    public String getBuildingName(String buildingName) {
        return buildingName;
    }
    public Boolean getBuildingState(String buildingName) {
        for(Building e : locatoinObjects){
            if(e.getName().equals(buildingName)){
                return e.getState();
            }
        }
        return false;
    }

    public void build(String name, Boolean state, String addres , String ownername){
        Building building = new Building(name, state, addres, ownername);
        locatoinObjects.add(building);
        buildingsCount ++;
                if (state){
                destroyedBildings++;
                }
                }

public String toString(){
        StringBuilder result = new StringBuilder("Локация " + name + " содержит: ");
        for(Building building: locatoinObjects){
        result.append(building.toString() + "; ");
        }

        if(inhabitant != null) {
        result.append(inhabitant.toString());
        }
        else {
        result.append(" . без обитателей");
        }
        return result.toString();
        }

    public String getName() {
        return name;
    }

    public int getBuildingsCount(){
        return buildingsCount;
    }
    public void setWeather(Weather newWeather){
        weather = newWeather;
    }
    public Weather setWeather(){
        return weather;
    }
    public int getDestroyedBildings(){return destroyedBildings;};
    public int compareTo(Location p){

        return name.compareTo(p.getName());
    }
}
