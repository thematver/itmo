package lab4;


import java.util.Objects;

public abstract class SceneObject {

    protected String name;

    public SceneObject(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SceneObject that = (SceneObject) o;
        return Objects.equals(name, that.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Объект сцены{" +
                "name='" + name + '\'' +
                '}';
    }
}
