package lab4.items;
import lab4.exceptions.BoxIsLockedException;

import java.util.List;

public interface Container {

    public List<Item> getItems() throws BoxIsLockedException;
    public void appendItems(Item ... items);

}
