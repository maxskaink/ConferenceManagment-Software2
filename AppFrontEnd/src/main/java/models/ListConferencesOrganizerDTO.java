package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ListConferencesOrganizerDTO {
    @JsonProperty("idOrganizer")
    private String idOrganizer;

    @JsonProperty("conferences")
    private List<ConferenceDTO> conferences;

    @JsonProperty("totalConference")
    private int totalConference;

    // Getters y setters
    public String getIdOrganizer() {
        return idOrganizer;
    }

    public void setIdOrganizer(String idOrganizer) {
        this.idOrganizer = idOrganizer;
    }

    public List<ConferenceDTO> getConferences() {
        return conferences;
    }

    public void setConferences(List<ConferenceDTO> conferences) {
        this.conferences = conferences;
    }

    public int getTotalConference() {
        return totalConference;
    }

    public void setTotalConference(int totalConference) {
        this.totalConference = totalConference;
    }
}
