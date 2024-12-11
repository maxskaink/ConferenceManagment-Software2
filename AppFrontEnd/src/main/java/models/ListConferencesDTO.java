package models;

import java.util.List;

public class ListConferencesDTO {
    private int totalConference;
    private List<ConferenceDTO> conferences;

    public ListConferencesDTO() {}
    public ListConferencesDTO(int totalConferences, List<ConferenceDTO> conferences) {
        this.conferences = conferences;
        totalConference = totalConferences;
    }


    public int getTotalConference() {
        return totalConference;
    }
    public void setTotalConference(int totalConference) {this.totalConference = totalConference;}
    public List<ConferenceDTO> getConferences() {
        return conferences;
    }
    public void setConferences(List<ConferenceDTO> conferences) {
        this.conferences = conferences;
    }

}
