package lab4.items;

import lab4.exceptions.BoxIsLockedException;
import lab4.persons.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box extends Item implements  Container, Sittable {

    private class Lock {
        private String password;
        private boolean isOpen;

        Lock(String password) {
            this.password = password;
        }

        Lock() {
            this.password = "dadada";
        }

        private boolean open(String password)  {
            if (this.password == password) {
                this.isOpen = true;
                return true;
            }
            return false;
        }
    }
    private Lock lock;
    private Person sitter;
    List<Item> items = new ArrayList<>();
    public Box(String name, String password) {
        super(name);
        lock = new Lock(password);
    }

    public Box(String name) {
        super(name);
        lock = new Lock();
        lock.isOpen = true;
    }


    public void tryToOpen(String password) {
        lock.open(password);
    }

    @Override
    public List<Item> getItems() throws BoxIsLockedException {

        if (lock.isOpen) return items;
        throw new BoxIsLockedException();
    }

    @Override
    public void appendItems(Item... items) {
        this.items = Arrays.asList(items);
    }

    @Override
    public void setSitter(Person sitter) {
        this.sitter = sitter;
    }

    @Override
    public Person getSitter() {
        return sitter;
    }
}
