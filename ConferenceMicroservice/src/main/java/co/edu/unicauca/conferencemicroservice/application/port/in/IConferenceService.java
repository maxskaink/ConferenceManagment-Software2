package co.edu.unicauca.conferencemicroservice.application.port.in;

import co.edu.unicauca.conferencemicroservice.application.dto.ConferenceDTO;
import co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import co.edu.unicauca.conferencemicroservice.domain.model.Conference;
import java.util.List;


public interface IConferenceService {
    /**
     *
     * @param conferenceToSave conference for save in repository
     * @return conference to save or null
     */
    Conference save(ConferenceDTO conferenceToSave);

    /**
     *
     * @param conferenceId id to find in repository
     * @return conference find or null
     */
    Conference findConferenceById(String conferenceId) throws NotFound;
    /**
     *
     * @return list<Conference> list of conference ative
     */
    List<Conference> findAllConferencesActive();

    /**
     *
     * @param idOrganizer id of organizer
     * @return List<Conference> DTO whit idOrganizaer, totalConference and all conference, active and no active
     *
     */
    List<Conference> findAllConfereceByIDOrganizer(String idOrganizer);
    /**
     *
     * @param conferenceId id of conferece to ypdate
     * @param conferenceToUpdate new conference for update
     * @return conference updated or null
     */
    Conference updateConference(String conferenceId, ConferenceDTO conferenceToUpdate) throws NotFound;
    /**
     *
     * @param conferenceId id to find in repository
     * @return conference eliminated or null
     */
     Conference deleteConference(String conferenceId) throws NotFound;
}
