package java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ConferenceEntity {
    private String id;
    private String place;
    private String name;
    private BasicDateEntity startDate;
    private BasicDateEntity finishDate;
    private String topic;
    private String idOrganizer;
    private String description;
    private boolean isActive;
}
