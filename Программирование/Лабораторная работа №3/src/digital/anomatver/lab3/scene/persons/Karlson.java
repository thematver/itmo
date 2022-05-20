package digital.anomatver.lab3.scene.persons;

import digital.anomatver.lab3.scene.SceneObject;
import digital.anomatver.lab3.scene.items.Container;
import digital.anomatver.lab3.scene.items.Item;
import digital.anomatver.lab3.scene.items.Tubule;

public class Karlson extends Person {

    public Karlson(String name) {
        super(name);

    }

    public Item searchForTubule(Container container) {
        System.out.println(getName() + " роется в " + ((Item) container).getName());
        for (Item item: container.getItems()) {
            if (item instanceof Tubule) {
                return item;
            }
        }
            return null;
    }

    public void toStare()
    {
        this.setEmotion(Emotion.INCONSOLABILITY);
        System.out.println(getName()+" смотрит в пустоту.");

    }


}

