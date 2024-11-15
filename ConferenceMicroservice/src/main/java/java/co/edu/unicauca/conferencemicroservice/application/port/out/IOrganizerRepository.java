package java.co.edu.unicauca.conferencemicroservice.application.port.out;

import java.co.edu.unicauca.conferencemicroservice.domain.exception.DuplicateInformation;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Organizer;
import java.util.List;

public interface IOrganizerRepository {
    /**
     * Save an organizer in db, if the information is duplicate it throws
     * a duplicateInformation exception
     * @param organizer Organizer to save
     * @return the saved Organizer
     */
    Organizer saveOrganizer(Organizer organizer) throws DuplicateInformation;

    /**
     * Find all the organizers in db
     * @return all organizer
     */
    List<Organizer> findAllOrganizers();

    /**
     * Find an organizer by his ID, if it doesn't exist throws
     * a NotFound Exception
     * @param id id of the organizer to find
     * @return the found organizer
     */
    Organizer findOrganizerById(String id) throws NotFound;

    /**
     * Delete an Organizer by ID, if it doesn't exist throws a
     * NotFound Exception
     * @param id id of organizer to delete
     * @return The deleted organizer
     */
    Organizer deleteOrganizerById(String id) throws NotFound;
}
