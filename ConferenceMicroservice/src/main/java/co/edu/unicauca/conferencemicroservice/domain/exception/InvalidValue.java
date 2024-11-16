package co.edu.unicauca.conferencemicroservice.domain.exception;

public class InvalidValue extends RuntimeException {
    public InvalidValue(String message) {
        super(message);
    }
}
