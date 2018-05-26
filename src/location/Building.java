package location;


public class Building implements Comparable<Building> {

    public Building(String name, Boolean state, String addres, String ownername){
        this.name = name;
        this.state = state;
        this.addres = addres;
        this.ownername = ownername;

    }
    private String name;
    private String addres;
    private Boolean state;
    private String ownername;
    public String getName() {
        return name;
    }

    public Boolean getState() {
        return state;
    }

    public String getAddres() {
        return addres;
    }

    public String getOwnername() {
        return ownername;
    }

    public String toString(){
        if (state){
            return name;
        }
        else{
            return "разрушенный " + name;
        }
    }
    public int compareTo(Building p){

        return name.compareTo(p.getName());
    }
}
