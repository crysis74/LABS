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
            case JUMP: return "Герой " + heroName + " решил, что ему скучно, поэтому он прыгнул.";
            case RUN: return "Герой " + heroName + " побежал в поисках пищи, но не смог  ее найти.";
            case PUT: return "Герой " + heroName + " решил положить свои вещи именно здесь.";
            case WATCH:return "Герой " + heroName + " решил оглядеться.";
            default: return "...";
        }

    }
    public String toString(){
        return "Герой сделал " + action;
    }
}
