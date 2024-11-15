package java.co.edu.unicauca.conferencemicroservice.application.port.in;

import java.co.edu.unicauca.conferencemicroservice.application.dto.UserDTO;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Organizer;
import java.util.List;

public interface IOrganizerService {
    /**
     *
     * Save the Organizer
     * @param organizerToSave Organzier complete to save
     * @return Organizer saved or null
     */
     Organizer saveOrganizer(UserDTO organizerToSave) ;

    /**
     *
     * @return List <Organizer> All Organizer or null
     */
     List<Organizer> findAllOrganizers() throws NotFound;

    /**
     *
     * @param id id Organizer to find
     * @return Organizer or null
     */
     Organizer findOrganizerById(String id) throws NotFound;

    /**
     *
     * @param id id of Organizer to update
     * @return Organizer was delete or null
     */
     Organizer deleteOrganizerById(String id) throws NotFound;
}
