package java.co.edu.unicauca.conferencemicroservice.domain.exception;

public class DupliateInformation extends RuntimeException {
    public DupliateInformation(String message) {
        super(message);
    }
}
