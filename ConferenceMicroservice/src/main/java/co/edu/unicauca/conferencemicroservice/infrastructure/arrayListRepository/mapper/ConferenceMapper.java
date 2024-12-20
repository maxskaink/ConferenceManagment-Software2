package co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.mapper;

import co.edu.unicauca.conferencemicroservice.domain.model.Conference;
import co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity.ConferenceEntity;

public class ConferenceMapper {
    /**
     * Map an instance of conference to ConferenceEntity
     * @param conference conference to map
     * @return Instance of conference
     */
    public static ConferenceEntity toConferenceEntity(Conference conference) {
        return new ConferenceEntity(
                conference.getId(),
                conference.getPlace(),
                conference.getName(),
                BasicDateMapper.toBasicDateEntity(conference.getStartDate()),
                BasicDateMapper.toBasicDateEntity(conference.getFinishDate()),
                conference.getTopic(),
                conference.getIdOrganizer(),
                conference.getDescription(),
                true
        );
    }

    /**
     * Map an instance of ConfrenceEntity to Conference
     * @param entity Entity to map
     * @return instance of conference
     */
    public static Conference toConference(ConferenceEntity entity) {
        return new Conference(
                entity.getId(),
                entity.getName(),
                BasicDateMapper.toBasicDate( entity.getStartDate() ),
                BasicDateMapper.toBasicDate( entity.getFinishDate() ),
                entity.getPlace(),
                entity.getTopic(),
                entity.getIdOrganizer(),
                entity.getDescription()

        );
    }
}