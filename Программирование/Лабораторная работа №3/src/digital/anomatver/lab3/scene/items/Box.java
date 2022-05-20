package digital.anomatver.lab3.scene.items;

import digital.anomatver.lab3.scene.persons.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box extends Item implements  Container, Sittable {


    private Person sitter;
    List<Item> items = new ArrayList<>();
    public Box(String name) {
        super(name);
    }



    @Override
    public List<Item> getItems() {
        return items;
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
