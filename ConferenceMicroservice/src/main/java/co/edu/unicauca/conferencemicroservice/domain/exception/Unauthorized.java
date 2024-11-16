package co.edu.unicauca.conferencemicroservice.domain.exception;

public class Unauthorized extends RuntimeException {
    public Unauthorized(String message) {
        super(message);
    }
}
