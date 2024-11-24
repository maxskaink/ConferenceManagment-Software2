package co.edu.unicauca.conferencemicroservice.domain.useCase;

import co.edu.unicauca.conferencemicroservice.infrastructure.mapper.MapperConference;
import co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import co.edu.unicauca.conferencemicroservice.domain.exception.Unauthorized;
import co.edu.unicauca.conferencemicroservice.domain.model.Conference;
import co.edu.unicauca.conferencemicroservice.application.port.in.IConferenceService;
import co.edu.unicauca.conferencemicroservice.application.port.out.IConferenceRepository;
import co.edu.unicauca.conferencemicroservice.application.port.out.IEventsHandler;
import java.util.List;
import java.util.UUID;

public class ConferenceService implements IConferenceService {

    private final IConferenceRepository repositoryConference;

    private final IEventsHandler eventsHandler;

    public ConferenceService(
            IConferenceRepository repository,
            IEventsHandler event
    ){
        this.repositoryConference = repository;
        this.eventsHandler = event;
    }

    @Override
    public Conference save(Conference conference) {

        if(conference == null)
            throw new InvalidValue("null conferenceToSave is invalid");

        //Create an instance of conference
        Conference conferenceToSave = new Conference (
                UUID.randomUUID().toString(), // Generate a ID for de conference
                conference.getName(),
                conference.getStartDate(),
                conference.getFinishDate(),
                conference.getPlace(),
                conference.getTopic(),
                conference.getIdOrganizer(),
                conference.getDescription()
        );
        //Save the conference in the db
        Conference conferenceCreated = repositoryConference.saveConference(conferenceToSave);
        //Notify the event
        eventsHandler.sendConference(conferenceCreated);

        return conferenceCreated;
    }

    @Override
    public Conference findConferenceById(String conferenceId) throws NotFound {
        if(conferenceId == null)
            throw new InvalidValue("null id is invalid");

        return repositoryConference.findById(conferenceId);
    }

    @Override
    public List<Conference> findAllConferencesActive() {
        return repositoryConference.findAllActive();
    }

    @Override
    public List<Conference> findAllConfereceByIDOrganizer(String idOrganizer) {
        if( idOrganizer== null)
            throw new InvalidValue("null idOrganizer is invalid");

        return repositoryConference.findByOrganizer(idOrganizer);
    }

    @Override
    public Conference updateConference(String conferenceId, Conference conferenceToUpdate) throws NotFound {
        if(conferenceId == null)
            throw new InvalidValue("null conferenceId is invalid");
        if(conferenceToUpdate == null)
            throw new InvalidValue("null conference to update is invalid");

        conferenceToUpdate.setId(conferenceId);

        Conference conference = this.findConferenceById(conferenceId);
        if( ! conference.getIdOrganizer().equals( conferenceToUpdate.getIdOrganizer() ))
            throw new Unauthorized("The organizer doesn't own this conference");

        return repositoryConference.updateConference(
                conferenceToUpdate,
                conferenceId
        );
    }

    @Override
    public Conference deleteConference(String conferenceId) throws NotFound {
        if(conferenceId == null)
            throw new InvalidValue("null conferenceId is invalid");

        return repositoryConference.deleteById(conferenceId);
    }
}
