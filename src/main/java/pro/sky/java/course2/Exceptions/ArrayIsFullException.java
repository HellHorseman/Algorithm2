package pro.sky.java.course2.Exceptions;

public class ArrayIsFullException extends RuntimeException {
    public ArrayIsFullException() {
    }

    public ArrayIsFullException(String message) {
        super(message);
    }

    public ArrayIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayIsFullException(Throwable cause) {
        super(cause);
    }

    public ArrayIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
