package lab4.exceptions;

public class BoxIsLockedException  extends Exception{

    public BoxIsLockedException()  {
        super("Коробочка закрыта!");
    }
}
