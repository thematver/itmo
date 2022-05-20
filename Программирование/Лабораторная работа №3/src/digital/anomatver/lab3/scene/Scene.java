package digital.anomatver.lab3.scene;

import digital.anomatver.lab3.scene.items.*;
import digital.anomatver.lab3.scene.persons.Boy;
import digital.anomatver.lab3.scene.persons.Emotion;
import digital.anomatver.lab3.scene.persons.Karlson;

public class Scene {

    public static void main(String[] args) {
        Karlson karlson = new Karlson("Карлсон");
        Boy malysh = new Boy("Малыш");
        karlson.sitDown(  new Chair("ИКЕА НИЛЬСОЛЛЕ"));
        karlson.toStare();
        Box footlar =  new Box("Картонная коробочка Малыша");
        footlar.appendItems(new Tubule("Длинная стеклянная трубочка"),new Peas("Горошина"));
        malysh.appendToInventory(new Box("Коробка Малыша"),
                new Chair("Стул Малыша"),
                new Peas("Горох"),
                new Peas("Старая засохшая горошинка"),
                new Peas("Добротный горох чрезвычайно умелого воителя"), footlar,
                new Peas("Горошек"),
                new Peas("Горошек")
               );
        karlson.say("А сейчас, "+malysh.getName()+", мы будем рыться в твоих вещах.");
        Tubule tubule = null;
        for (Item item:malysh.getInventory()) {

            karlson.say("Я нашел "+ item.getName());

            if (item instanceof Sittable) {
                karlson.standUp((Sittable) item);
                karlson.setEmotion(Emotion.SURPRISE);
                karlson.say("А на эту вещь можно сесть.");
                karlson.sitDown((Sittable) item);
            }
            if (item instanceof Box) {
                karlson.setEmotion(Emotion.SURPRISE);
                karlson.say("А в этом контейнере  можно порыться.");
                Item found = karlson.searchForTubule((Box) item);
                if (found != null) {
                    karlson.setEmotion(Emotion.DELIGHT);
                    karlson.say("Я нашел стеклянную дудочку! Отложу ее. Осталось найти горох.");
                    tubule = (Tubule) found;
                    
                }
            }
            if (item instanceof Peas) {
                if (tubule!=null) {
                    tubule.appendItems(item);
                    System.out.println("Положу эту горошину прямо в дудочку");
                }

            }
        }
        
        karlson.say("А ведь когда-то ты стрелял из этой дудочки!");
        malysh.say("Я и сейчас могу");
        malysh.shoot(tubule, karlson);




    }

}
