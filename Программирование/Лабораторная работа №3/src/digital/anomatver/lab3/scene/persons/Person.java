package digital.anomatver.lab3.scene.persons;

import digital.anomatver.lab3.scene.SceneObject;
import digital.anomatver.lab3.scene.items.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class Person extends SceneObject {


    private List<Item> inventory = new ArrayList<Item>();
    private Emotion emotion;

    public Person(String name) {
        super(name);
    }

    public Emotion getEmotion() {

        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        String message = this.getName()+" почувствовал ";
        switch (emotion) {
            case PAIN: message = message.concat("настоящую боль."); break;
            case ANGER: message = message.concat("злость. "); break;
            case INCONSOLABILITY: message = message.concat("безутешность."); break;
            case SURPRISE: message = message.concat("удивление."); break;
            case DELIGHT: message = message.concat("восхищение."); break;
            default: message = message.concat("что-то."); break;
        }
        this.emotion = emotion;
        System.out.println(message);
    }

    public String getName() {
        return name;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void appendToInventory(Item ... items) {
        inventory.addAll(Arrays.asList(items));
    }
    public void sitDown(Sittable item) {
        item.setSitter(this);
        System.out.println(this.getName() + " сел на " + ((Item) item).getName());
    }

    public void standUp(Sittable item) {
        if (item.getSitter()!=null) {
            item.setSitter(null);
            System.out.println(this.getName() + " встал с " + ((Item) item).getName());
        }
    }

    public void say(String text) {
        System.out.println("["+getName()+"] "+text);
    }

}
