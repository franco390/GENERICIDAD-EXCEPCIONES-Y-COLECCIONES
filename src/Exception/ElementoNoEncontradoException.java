package Exception;

public class ElementoNoEncontradoException extends RuntimeException {
    public ElementoNoEncontradoException() {
        super("El elemento no fue encontrado.");
    }
}
