package co.edu.unicauca.conferencemicroservice.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ListConferencesDTO {
    private int                 totalConferences;
    private List<ConferenceDTO> conferences;
    public ListConferencesDTO() {}
}
