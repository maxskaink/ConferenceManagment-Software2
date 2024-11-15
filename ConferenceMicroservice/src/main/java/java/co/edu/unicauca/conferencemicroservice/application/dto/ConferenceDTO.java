package java.co.edu.unicauca.conferencemicroservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.co.edu.unicauca.conferencemicroservice.domain.model.valueObjects.BasicDate;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceDTO {
    private String id;
    private String name;
    private BasicDate startDate;
    private BasicDate finishDate;
    private String place;
    private String topic;
    private String idOrganizer;
    private String description;
}
