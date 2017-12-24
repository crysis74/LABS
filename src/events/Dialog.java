package events;

import heroes.AbstractHero;
import location.Weather;

import java.util.ArrayList;

public class Dialog implements Event  {
    private AbstractHero speaker1;
    private AbstractHero speaker2;
    private ArrayList<String> dialogText;
    private Weather weather;

    public Dialog(AbstractHero speaker1, AbstractHero speaker2, ArrayList<String> dialogText, Weather weather){
        this.speaker1 = speaker1;
        this.speaker2 = speaker2;
        this.dialogText = dialogText;
        this.weather = weather;
    }
    public String tellStory(){
        class DialogMaker {
            private int number;
            private AbstractHero speaker1;
            private AbstractHero speaker2;
            private Weather weather;

            DialogMaker(AbstractHero speaker1, AbstractHero speaker2,Weather weather) {
                this.speaker1 = speaker1;
                this.speaker2 = speaker2;
                number = 0;
                this.weather = weather;

            }

            StringBuilder dialog = new StringBuilder("Между " + speaker1.sayName() + " и " + speaker2.sayName() +
                    " произошел следующий диалог: \n");

            public void showWeather() {
                switch (weather) {
                    case FOG:
                        dialog.append("Герои не видели даже свои руки из-за густого тумана.\n");
                        break;
                    case SUN:
                        dialog.append("Хорошо, что здесь была хорошая солнечная погода.\n");
                        break;
                    case DARK:
                        dialog.append("Герои были испуганы, ведь на улице было темно.\n");
                        break;
                }

            }

            public void addPhraze(String phrase, int i) {

                    if (number % 2 == 0) {
                        dialog.append(speaker1.sayName() + ": ");
                    } else {
                        dialog.append(speaker2.sayName() + ": ");
                    }
                    dialog.append(dialogText.get(i) + "\n");
                    number++;
                }

            public String getDialog() {
                return dialog.toString();
            }
        }
        DialogMaker dia = new DialogMaker(speaker1, speaker2, weather);
        dia.showWeather();
        for (int i=0;i < dialogText.size(); i++){
            dia.addPhraze(dialogText.get(i),i);
        }
            return dia.getDialog();
        }

    public String toString(){
        return "диалог между " + speaker1.sayName() + " и " + speaker2.sayName();
    }
}
