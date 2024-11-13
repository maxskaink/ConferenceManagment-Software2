package java.co.edu.unicauca.conferencemicroservice.domain.port.out;

import java.co.edu.unicauca.conferencemicroservice.domain.exception.DuplicateInformation;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Conference;
import java.util.List;

public interface IConferenceRepository {
    /**
     * Save de conference in the database if it hava duplicate information,
     * it throws an DuplicateInformation exception
     * @param conference Conference to save in DB
     * @return the conference saved in database
     */
    Conference saveConference(Conference conference) throws DuplicateInformation;

    /**
     * Find a Conference by id, if it doesn't exist it throws,
     * a NotFound exception
     * @param id id to search
     * @return the conference
     */
    Conference findById(String id);

    /**
     * Update Conference if it doesn't exist it throws,
     * a NotFound exception
     * @param conference Information of the conference
     * @param id id of the conference to update
     * @return the updated conference
     */
    Conference updateConference(Conference conference, String id) throws NotFound;

    /**
     * Delete and conference by id, if it doesn't exist it throws,
     * a NotFound exception
     * @param id id of the conference to delete
     * @return the deleted conference
     */
    Conference deleteById(String id) throws  NotFound;

    /**
     * Find all the active conferences
     * @return conferences active
     */
    List<Conference> findAllActive();

    /**
     * Find Conference by Id Organizer if doesn't exist
     * throw a NotFound Exception
     * @param idOrganizer id of the organizer to search
     * @return the conferences with id conferences
     */
    List<Conference> findByOrganizer(String idOrganizer) throws NotFound;

    /**
     * Find All the conferences even if are inactive
     * @return all the conferences
     */
    List<Conference> findAll();
}
