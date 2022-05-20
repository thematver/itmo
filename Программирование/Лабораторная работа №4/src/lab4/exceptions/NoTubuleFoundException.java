package lab4.exceptions;

public class NoTubuleFoundException  extends Exception {
    public NoTubuleFoundException()  {
        super("Карлсон не смог найти трубочку в этом контейнере, как ни старался!");
    }
}
