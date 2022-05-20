package digital.anomatver.lab3.scene.items;

import digital.anomatver.lab3.scene.SceneObject;

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
