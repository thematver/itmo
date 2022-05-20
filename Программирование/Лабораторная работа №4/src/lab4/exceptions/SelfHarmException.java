package lab4.exceptions;

public class SelfHarmException extends RuntimeException {
    public SelfHarmException() {
        super("Нельзя стрелять в самого себя!");
    }
}
