package lab4;

import lab4.exceptions.BoxIsLockedException;
import lab4.exceptions.NoTubuleFoundException;
import lab4.exceptions.SelfHarmException;
import lab4.items.*;
import lab4.persons.*;

import java.util.Random;


public class Scene {

    public static void main(String[] args) {
        Karlson karlson = new Karlson("Карлсон");
        Boy malysh = new Boy("Малыш");
        karlson.sitDown(  new Chair("ИКЕА НИЛЬСОЛЛЕ"));
        karlson.toStare();
        karlson.say("И все-таки не люблю я дешевую шведскую мебель");
        karlson.sitDown(new Sittable() {
            private Person sitter;

            @Override
            public void setSitter(Person sitter) {
                this.sitter = sitter;
            }

            @Override
            public Person getSitter() {
                return this.sitter;
            }

            @Override
            public String getName() {
                return "Роскошная русская лавочка";
            }
        });
        Box footlar =  new Box("Картонная коробочка Малыша");
        footlar.appendItems(new Tubule("Длинная стеклянная трубочка"),new Tubule.Peas("Горошина"));
        malysh.appendToInventory(new Box("Коробка Малыша"),
                new Chair("Стул Малыша"),
                new Tubule.Peas("Горох"),
                new Tubule.Peas("Старая засохшая горошинка"),
                new Tubule.Peas("Добротный горох чрезвычайно умелого воителя"), footlar,
                new Tubule.Peas("Горошек"),
                new Tubule.Peas("Горошек")
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
                try {
                    Item found = karlson.searchForTubule((Box) item);
                    karlson.setEmotion(Emotion.DELIGHT);
                    karlson.say("Я нашел стеклянную дудочку! Отложу ее. Осталось найти горох.");
                    tubule = (Tubule) found;
                }
                catch (NoTubuleFoundException | BoxIsLockedException e) {
                    System.out.println(e.getMessage());
                }

            }
            if (item instanceof Tubule.Peas) {
                if (tubule!=null) {
                    tubule.appendItems(item);
                    System.out.println("Положу эту горошину прямо в дудочку");
                }

            }
        }
        
        karlson.say("А ведь когда-то ты стрелял из этой дудочки!");
        malysh.say("Я и сейчас могу");

            malysh.shoot(tubule, karlson);

            try {
                malysh.shoot(tubule, malysh);
            }
            catch (SelfHarmException e) {
                malysh.say("Ай-ай!");
                malysh.setEmotion(Emotion.PAIN);
            }
    class Balloon extends Item {

        public Balloon(String name) {
            super(name);
        }
        public void inflate() {
            System.out.println(this.name + " надут!");
        }
    }
        karlson.say("Не расстраивайся! Я нашел огромный воздушный шар, который можно надуть до огромного размера!");
            Balloon balloon = new Balloon("Синий, новый воздушный шарик");
            karlson.appendToInventory(balloon);
            balloon.inflate();
        }





    }

