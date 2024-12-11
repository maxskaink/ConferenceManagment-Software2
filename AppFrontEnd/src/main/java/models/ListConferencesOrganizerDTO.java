package models;

import java.util.List;

public class ListConferencesOrganizerDTO {
    private int totalConference;
    private String idOrganizer;
    private List<ConferenceDTO> conferences;

    public ListConferencesOrganizerDTO(){}
    public ListConferencesOrganizerDTO(int totalConference, String idOrganizer, List<ConferenceDTO> conferences) {}

    public int getTotalConference() {
        return totalConference;
    }
    public void setTotalConference(int totalConferences) {
        this.totalConference = totalConferences;
    }
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
}
