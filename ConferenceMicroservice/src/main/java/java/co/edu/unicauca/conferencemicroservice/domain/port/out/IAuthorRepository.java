package java.co.edu.unicauca.conferencemicroservice.domain.port.out;

import java.co.edu.unicauca.conferencemicroservice.domain.exception.DuplicateInformation;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Author;
import java.util.List;

public interface IAuthorRepository {
    /**
     * Find an Author by ID if it doesn't exist throw an NotFound exception
     * @param id id of the author to search
     * @return The author with id
     */
    Author findById(String id) throws NotFound;

    /**
     * Finds all the Authors of the db
     * @return the authors in db
     */
    List<Author> findAllAuthors();

    /**
     * Save an author in db, if the values ar dupliacte, throws an DuplicateInformation
     * @param author Author to save in DB
     * @return The author saved in db
     */
    Author saveAuthor(Author author) throws DuplicateInformation;

    /**
     * Delete an author in db, if it doesn't exist, throw an
     * NotFound exception
     * @param idAuthor Id of the author to delete
     * @return The deleted Author
     */
    Author deleteAuthor(String idAuthor) throws NotFound;
}
