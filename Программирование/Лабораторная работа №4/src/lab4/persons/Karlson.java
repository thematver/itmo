package lab4.persons;

import lab4.exceptions.BoxIsLockedException;
import lab4.exceptions.NoTubuleFoundException;
import lab4.items.*;

public class Karlson extends Person {

    public Karlson(String name) {
        super(name);

    }

    public Item searchForTubule(Container container) throws NoTubuleFoundException, BoxIsLockedException {
        System.out.println(getName() + " роется в " + ((Item) container).getName());
        try {
            for (Item item : container.getItems()) {
                if (item instanceof Tubule) {
                    return item;
                }
            }
        }
        catch (BoxIsLockedException e) {
            throw new BoxIsLockedException();
        }
        throw new NoTubuleFoundException();
    }

    public void toStare()
    {
        this.setEmotion(Emotion.INCONSOLABILITY);
        System.out.println(getName()+" смотрит в пустоту.");

    }


}

