package digital.anomatver.lab3.scene.items;
import java.util.List;

public interface Container {

    public List<Item> getItems();
    public void appendItems(Item ... items);

}
