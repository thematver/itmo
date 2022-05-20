package digital.anomatver.lab3.scene.persons;

import digital.anomatver.lab3.scene.items.Item;

import digital.anomatver.lab3.scene.items.Tubule;

public class Boy  extends Person {


    public Boy(String name) {
        super(name);
    }

    public void shoot(Tubule tubule, Person person) {
        for (Item peas:  tubule.getItems()) {
            System.out.println(getName()+" стреляет в "+person.getName() + " с помощью "+peas.getName());
            person.setEmotion(Emotion.PAIN);
        }
    }



}
