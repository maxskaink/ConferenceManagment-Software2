package models;

import java.util.List;

public class ListConferencesDTO {
    private List<ConferenceDTO> conferences;
    private int totalConferences; // Cambiado de "totalConference" a "totalConferences"

    // Getters y setters
    public List<ConferenceDTO> getConferences() {
        return conferences;
    }

    public void setConferences(List<ConferenceDTO> conferences) {
        this.conferences = conferences;
    }

    public int getTotalConferences() {
        return totalConferences;
    }

    public void setTotalConferences(int totalConferences) {
        this.totalConferences = totalConferences;
    }
}

