package java.co.edu.unicauca.conferencemicroservice.domain.exception;

public class NotFound extends RuntimeException {
    public NotFound(String message) {
        super(message);
    }
}
