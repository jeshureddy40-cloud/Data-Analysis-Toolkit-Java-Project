public class DataException extends Exception {

    // Default constructor
    public DataException() {
        super("Data processing error occurred");
    }

    // Constructor with custom message
    public DataException(String message) {
        super(message);
    }

    // Constructor with message + original exception
    public DataException(String message, Throwable cause) {
        super(message, cause);
    }
}
