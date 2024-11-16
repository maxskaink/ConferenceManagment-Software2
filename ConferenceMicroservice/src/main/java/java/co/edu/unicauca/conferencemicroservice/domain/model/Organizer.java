package java.co.edu.unicauca.conferencemicroservice.domain.model;

import jakarta.websocket.RemoteEndpoint;

import java.co.edu.unicauca.conferencemicroservice.domain.model.valueObjects.BasicDate;

public class Organizer extends Author{
    public Organizer(String id, String name, String email){
        super(id, name, email);
    }

    /**
     * Create an instance of Conference, by Santiago
     * @param name name of the Conference
     * @param startDate start date of the conference
     * @param finishDate finishDate of the conference
     * @param place place of the conference
     * @param topic topics of the conference
     * @param description description of the conference
     * @return The instance of the conference
     */
    public Conference createConference(
            String id,
            String name,
            BasicDate startDate,
            BasicDate finishDate,
            String place,
            String topic,
            String description
    ){
        return new Conference(id, name, startDate, finishDate, place, topic, this.getId(), description);
    }
}
