public class NotRegisteredException extends Throwable {
    public NotRegisteredException(String name) {
        super("Игрок " + name + " не найден");
    }
}