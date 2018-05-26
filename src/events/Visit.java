package events;

import Mistakes.DestroyedBuildingException;
import heroes.Visitor;
import location.Location;

public class Visit implements Event {

        private Location location;
        private Visitor visitor;
        private Visitor carrier;
        private String name;


        public Visit(Location location,String name, Visitor visitor, Visitor carrier){
            this.location = location;
            this.visitor = visitor;
            this.carrier = carrier;
            this.name = name;
        }

        public String tellStory() {
            try {
                StringBuilder visit = new StringBuilder();
                if (location.getBuildingState(name)) {
                    throw new DestroyedBuildingException(location, name);
                }

                if (carrier == null) {
                    visit.append(visitor.toString() + " сам вошел в здание: " + location.getBuildingName(name) + " и решил осмотреться в поисках помощи.");
                } else {
                    visit.append(visitor.toString() + " заносится " + carrier.toString() + " в здание: " + location.getBuildingName(name));
                }
                return visit.toString();
            }
            catch (DestroyedBuildingException ex){
                return ex.toString();
            }
        }
        public String toString(){
            return visitor.sayName() + " находится в " + location.getBuildingName(name);
        }
    }


