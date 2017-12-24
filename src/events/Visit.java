package events;

import Mistakes.DestroyedBuildingException;
import heroes.Visitor;
import location.Location;

public class Visit implements Event {

        private Location location;
        private Visitor visitor;
        private Visitor carrier;
        private int number;


        public Visit(Location location, int number, Visitor visitor, Visitor carrier){
            this.location = location;
            this.visitor = visitor;
            this.carrier = carrier;
            this.number = number;
        }

        public String tellStory(){
            StringBuilder visit = new StringBuilder();
            if (location.getBuildingState(number)){
                throw new DestroyedBuildingException(location , number);
            }
            if (carrier == null) {
                visit.append(visitor.toString() +" сам вошел в здание: " + location.getBuildingName(number) + " и решил осмотреться в поисках помощи.");
            }
            else {
                visit.append(visitor.toString() + " заносится " + carrier.toString() + " в здание: " + location.getBuildingName(number));
            }
            return visit.toString();
        }
        public String toString(){
            return visitor.sayName() + " находиться в " + location.getBuildingName(number);
        }
    }


