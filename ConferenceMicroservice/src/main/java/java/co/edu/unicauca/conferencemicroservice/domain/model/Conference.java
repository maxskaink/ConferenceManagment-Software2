package java.co.edu.unicauca.conferencemicroservice.domain.model;

import java.co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import java.co.edu.unicauca.conferencemicroservice.domain.model.valueObjects.BasicDate;
public class Conference { private String id;
    private String name;
    private BasicDate startDate;
    private BasicDate finishDate;
    private String place;
    private String topic;
    private Organizer organizer;
    private String description;

    /**
     * Constructor of conference
     * @param name String name of conference
     * @param startDate BasicDate start date of conference
     * @param finishDate BasicDate finish date of cconference
     * @param place String Placfe of conference
     * @param topic String topic of confernece
     * @param organizer Organizer organizer to created confererence
     * @param description Strign description of conference
     */
    public Conference(String name, BasicDate startDate, BasicDate finishDate, String place, String topic, Organizer organizer, String description) {
        //Validate the values
        validateString("name",name);
        validateString("place ", place);
        validateString("topic", topic );
        validateString("description", description);
        //Assigns the values
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.place = place;
        this.topic = topic;
        this.organizer = organizer;
        this.description = description;
    }
    public Conference(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BasicDate getStartDate() {
        return startDate;
    }

    public void setStartDate(BasicDate startDate) {
        this.startDate = startDate;
    }

    public BasicDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(BasicDate finishDate) {
        this.finishDate = finishDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Validate if a string is not empty or null
     * @param name name of the field
     * @param value value of the field
     */
    private void validateString(String name, String value){
        if( value == null || value.isEmpty())
            throw  new InvalidValue(name + " is empty");
    }

    /**
     * Validate organizer is not null
     * @param objOrganizer organizer to validate
     */
    private void validateOrganizer(Organizer objOrganizer){
        if(objOrganizer  == null)
            throw  new InvalidValue("Organizer is null");
    }
}
