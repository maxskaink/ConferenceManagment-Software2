package java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.repository;

import org.springframework.stereotype.Repository;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.DuplicateInformation;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Conference;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IConferenceRepository;
import java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity.BasicDateEntity;
import java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity.ConferenceEntity;
import java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.mapper.BasicDateMapper;
import java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.mapper.ConferenceMapper;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConferenceRepository implements IConferenceRepository {

    private final List<ConferenceEntity> conferences;

    public ConferenceRepository() {
        this.conferences = new ArrayList<>();
        generateBaseInfo();
    }

    @Override
    public Conference saveConference(Conference conference) throws DuplicateInformation {
        for (ConferenceEntity conferenceEntity : conferences) {
            if (conferenceEntity.getId().equals(conference.getId())) {
                throw new DuplicateInformation("Conference with id " + conference.getId() + " already exists");
            }
        }
        conferences.add(ConferenceMapper.toConferenceEntity(conference));
        return conference;
    }

    @Override
    public Conference findById(String id) throws NotFound {
        for (ConferenceEntity conferenceEntity : conferences) {
            if (conferenceEntity.getId().equals(id) && conferenceEntity.isActive()) {
                return ConferenceMapper.toConference(conferenceEntity);
            }
        }
        throw new NotFound("Conference with id " + id + " not found");
    }

    @Override
    public Conference updateConference(Conference conference, String id) throws NotFound {
        ConferenceEntity foundConference = null;

        for (ConferenceEntity conferenceEntity : conferences) {
            if (conferenceEntity.getId().equals(id)) {
                foundConference = conferenceEntity;
                break;
            }
        }

        if (foundConference == null) {
            throw new NotFound("Conference with id " + id + " not found");
        }

        foundConference.setPlace(conference.getPlace());
        foundConference.setName(conference.getName());
        foundConference.setDescription(conference.getDescription());
        foundConference.setTopic(conference.getTopic());
        foundConference.setStartDate(BasicDateMapper.toBasicDateEntity(conference.getStartDate()));
        foundConference.setFinishDate(BasicDateMapper.toBasicDateEntity(conference.getFinishDate()));
        foundConference.setIdOrganizer(conference.getIdOrganizer().getId());

        return ConferenceMapper.toConference(foundConference);
    }

    @Override
    public Conference deleteById(String id) throws NotFound {
        for (ConferenceEntity conferenceEntity : conferences) {
            if (conferenceEntity.getId().equals(id)) {
                conferenceEntity.setActive(false);
                return ConferenceMapper.toConference(conferenceEntity);
            }
        }
        throw new NotFound("Conference with id " + id + " not found");
    }

    @Override
    public List<Conference> findAllActive() {
        List<Conference> activeConferences = new ArrayList<>();
        for (ConferenceEntity conferenceEntity : conferences) {
            if (conferenceEntity.isActive()) {
                activeConferences.add(ConferenceMapper.toConference(conferenceEntity));
            }
        }
        return activeConferences;
    }

    @Override
    public List<Conference> findByOrganizer(String idOrganizer) throws NotFound {
        List<Conference> organizerConferences = new ArrayList<>();
        for (ConferenceEntity conferenceEntity : conferences) {
            if (conferenceEntity.getIdOrganizer().equals(idOrganizer)) {
                organizerConferences.add(ConferenceMapper.toConference(conferenceEntity));
            }
        }
        if (organizerConferences.isEmpty()) {
            throw new NotFound("No conferences found for organizer with id " + idOrganizer);
        }
        return organizerConferences;
    }

    @Override
    public List<Conference> findAll() {
        List<Conference> allConferences = new ArrayList<>();
        for (ConferenceEntity conferenceEntity : conferences) {
            allConferences.add(ConferenceMapper.toConference(conferenceEntity));
        }
        return allConferences;
    }

    private void generateBaseInfo() {
        // Inicialización de datos básicos
        conferences.add(new ConferenceEntity(
                "9876",
                "Tech Conference",
                "An advanced tech conference",
                new BasicDateEntity(16,8,2024),
                new BasicDateEntity(17,8,2024),
                "Important tipics",
                "5555",
                "Important conference",
                true)
        );

    }
}
