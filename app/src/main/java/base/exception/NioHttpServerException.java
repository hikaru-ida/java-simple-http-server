package base.exception;

public final class NioHttpServerException extends Exception {
    public NioHttpServerException(Throwable exception) {
        super(exception);
    }
}
