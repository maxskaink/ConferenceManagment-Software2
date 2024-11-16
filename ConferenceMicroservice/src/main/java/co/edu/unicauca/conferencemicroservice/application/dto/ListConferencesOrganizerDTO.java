package co.edu.unicauca.conferencemicroservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ListConferencesOrganizerDTO {
    private int                 totalConference;
    private String              idOrganizer;
    private List<ConferenceDTO> conferences;
    public ListConferencesOrganizerDTO(){}
}
