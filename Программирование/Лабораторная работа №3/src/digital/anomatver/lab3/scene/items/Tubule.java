package digital.anomatver.lab3.scene.items;

import java.util.ArrayList;
import java.util.List;

public class Tubule extends Item implements Container {
    List<Item> items = new ArrayList<>();

    public Tubule(String name) {
        super(name);
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void appendItems(Item... items) {
        for (Item item:items) {
            if (item instanceof Peas) {
                this.items.add(item);
            }
        }
    }
}
