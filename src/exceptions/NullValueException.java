package exceptions;

public class NullValueException extends RuntimeException {
    public NullValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
