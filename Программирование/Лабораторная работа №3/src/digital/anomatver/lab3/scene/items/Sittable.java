package digital.anomatver.lab3.scene.items;

import digital.anomatver.lab3.scene.persons.Person;

public interface Sittable {

    public void setSitter(Person sitter);
    public Person getSitter();

}
