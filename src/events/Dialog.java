package events;

import heroes.Visitor;

public class Dialog implements Event {
    private Visitor speaker1;
    private Visitor speaker2;

    public Dialog(Visitor speaker1, Visitor speaker2){
        this.speaker1 = speaker1;
        this.speaker2 = speaker2;
    }
    public String tellStory(){

    }

}
