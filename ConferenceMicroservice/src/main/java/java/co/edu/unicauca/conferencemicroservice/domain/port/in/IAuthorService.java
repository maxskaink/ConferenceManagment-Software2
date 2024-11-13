package java.co.edu.unicauca.conferencemicroservice.domain.port.in;

import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Author;

public interface IAuthorService {

    Author save(Author authorToSave);
    Author deleteById(String id) throws NotFound;
    Author findBiId(String id) throws NotFound;
}
