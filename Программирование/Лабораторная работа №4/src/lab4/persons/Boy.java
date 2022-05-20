package lab4.persons;

import lab4.exceptions.SelfHarmException;
import lab4.items.*;

public class Boy  extends Person {


    public Boy(String name) {
        super(name);
    }

    public void shoot(Tubule tubule, Person person) {
        for (Item peas:  tubule.getItems()) {

            if (person.equals(this)) {
                throw new SelfHarmException();
            }
            System.out.println(getName()+" стреляет в "+person.getName() + " с помощью "+peas.getName());
            person.setEmotion(Emotion.PAIN);
        }
    }



}
