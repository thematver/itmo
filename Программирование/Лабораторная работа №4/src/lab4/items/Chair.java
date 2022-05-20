package lab4.items;

import lab4.persons.Person;

public class Chair  extends Item implements Sittable  {

    private Person sitter;

    public Chair(String name) {
        super(name);
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
