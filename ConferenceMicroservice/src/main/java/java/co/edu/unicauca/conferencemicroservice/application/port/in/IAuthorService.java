package java.co.edu.unicauca.conferencemicroservice.application.port.in;

import java.co.edu.unicauca.conferencemicroservice.application.dto.UserDTO;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Author;

public interface IAuthorService {
    /**
     * Save an Author in db
     * @param authorToSave info of the author to save
     * @return the saved author
     */
    Author save(UserDTO authorToSave);

    /**
     * Delete an Author by id
     * @param id id of the author to delete
     * @return the deleted author
     * @throws NotFound author doesn't exist
     */
    Author deleteById(String id) throws NotFound;

    /**
     * Find an Author by id
     * @param id id of the author to search
     * @return the author found
     * @throws NotFound if the author doesn't exist
     */
    Author findById(String id) throws NotFound;
}
