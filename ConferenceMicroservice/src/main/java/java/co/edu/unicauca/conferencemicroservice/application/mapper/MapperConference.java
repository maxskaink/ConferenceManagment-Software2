package java.co.edu.unicauca.conferencemicroservice.application.mapper;

import java.co.edu.unicauca.conferencemicroservice.application.dto.ConferenceDTO;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Conference;

public class MapperConference {
    public static Conference toConference(ConferenceDTO conferenceDTO){
        return new Conference(
                conferenceDTO.getName(),
                conferenceDTO.getStartDate(),
                conferenceDTO.getFinishDate(),
                conferenceDTO.getPlace(),
                conferenceDTO.getTopic(),
                conferenceDTO.getIdOrganizer(),
                conferenceDTO.getDescription()
        );
    }

    public static ConferenceDTO toConferenceDTO( Conference conference){
        return new ConferenceDTO(
                conference.getId(),
                conference.getName(),
                conference.getStartDate(),
                conference.getFinishDate(),
                conference.getPlace(),
                conference.getTopic(),
                conference.getIdOrganizer(),
                conference.getDescription()
        );
    }
}