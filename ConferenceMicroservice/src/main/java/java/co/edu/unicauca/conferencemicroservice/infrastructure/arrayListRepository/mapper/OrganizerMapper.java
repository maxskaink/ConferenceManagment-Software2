package java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.mapper;

import java.co.edu.unicauca.conferencemicroservice.domain.model.Organizer;
import java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity.OrganizerEntity;

public class OrganizerMapper {
    public static OrganizerEntity toOrganizerEntity(Organizer organizer) {
        return new OrganizerEntity(
                organizer.getId(),
                organizer.getName(),
                organizer.getEmail(),
                true
        );
    }
    public static  Organizer toOrganizer(OrganizerEntity organizerEntity) {
        return new Organizer(
                organizerEntity.getId(),
                organizerEntity.getName(),
                organizerEntity.getEmail()
        );
    }
}
