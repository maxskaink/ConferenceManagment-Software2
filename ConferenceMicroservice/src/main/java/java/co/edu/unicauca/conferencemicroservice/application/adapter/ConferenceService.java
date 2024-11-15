package java.co.edu.unicauca.conferencemicroservice.application.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.co.edu.unicauca.conferencemicroservice.application.dto.ConferenceDTO;
import java.co.edu.unicauca.conferencemicroservice.application.mapper.MapperConference;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Conference;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Organizer;
import java.co.edu.unicauca.conferencemicroservice.application.port.in.IConferenceService;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IConferenceRepository;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IEventsHandler;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IOrganizerRepository;
import java.util.List;

@Service
public class ConferenceService implements IConferenceService {

    private final IConferenceRepository repositoryConference;

    private final IOrganizerRepository repositoryOrganizer;

    private final IEventsHandler eventsHandler;

    @Autowired
    public ConferenceService( IConferenceRepository repository, IOrganizerRepository repositoryOrganizer, IEventsHandler event){
        this.repositoryConference = repository;
        this.repositoryOrganizer = repositoryOrganizer;
        this.eventsHandler = event;
    }

    @Override
    public Conference save(ConferenceDTO conferenceDTO) {

        if(conferenceDTO == null)
            throw new InvalidValue("null conferenceToSave is invalid");

        //Find the organizer
        Organizer organizer = repositoryOrganizer.findOrganizerById(conferenceDTO.getIdOrganizer());

        //Create an instance of conference
        Conference conferenceToSave = organizer.createConference(
                conferenceDTO.getName(),
                conferenceDTO.getStartDate(),
                conferenceDTO.getFinishDate(),
                conferenceDTO.getPlace(),
                conferenceDTO.getTopic(),
                conferenceDTO.getDescription()
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
    public Conference updateConference(String conferenceId, ConferenceDTO conferenceToUpdate) throws NotFound {
        if(conferenceId == null)
            throw new InvalidValue("null conferenceId is invalid");
        if(conferenceToUpdate == null)
            throw new InvalidValue("null conference to update is invalid");

        return repositoryConference.updateConference(
                MapperConference.toConference(conferenceToUpdate),
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
