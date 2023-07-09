package pro.sky.java.course2.Exceptions;

public class ParametrIsNullException extends RuntimeException{
    public ParametrIsNullException() {
    }

    public ParametrIsNullException(String message) {
        super(message);
    }

    public ParametrIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParametrIsNullException(Throwable cause) {
        super(cause);
    }

    public ParametrIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
