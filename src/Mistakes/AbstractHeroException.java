package Mistakes;

import heroes.Actions;

public class AbstractHeroException extends RuntimeException{
    private Actions actions;
    public AbstractHeroException(Actions actoins){
        this.actions = actoins;
    }
    public  String toString(){
        return " Ошибка вызова действия " + actions + " у не абстрактого героя.";

    }
}
