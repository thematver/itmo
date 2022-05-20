package lab4.items;

import lab4.SceneObject;

public abstract class Item extends SceneObject {

    public Item(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       this.name = name;
    }


}
