package co.edu.unicauca.conferencemicroservice.domain.exception;

public class DuplicateInformation extends RuntimeException {
    public DuplicateInformation(String message) {
        super(message);
    }
}
