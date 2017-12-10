package events;

import heroes.*;

public class Action implements Event {
    private Actionable hero;
    private Actions action;
    public Action(Actionable hero,  Actions action) {
        this.hero = hero;
        this.action = action;
    }
    public String tellStory(){
        String heroName = null;
        if(hero instanceof AbstractHero){
            heroName = ((AbstractHero)hero).sayName();
        }

        switch (action){
            case JUMP: return "герой " + heroName + " прыгнул";
            default: return "ыыыыы";
        }
    }
}
