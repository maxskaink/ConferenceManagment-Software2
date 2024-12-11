
package models;


public class Conference {
    private String      id;
    private String      name;
    private BasicDate   startDate;
    private BasicDate   finishDate;
    private String      place;
    private String      topic;
    private String      idOrganizer;
    private String      description;

    public Conference(String id, String name, BasicDate startDate, BasicDate finishDate, String place, String topic, String idOrganizer, String description) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.place = place;
        this.topic = topic;
        this.idOrganizer = idOrganizer;
        this.description = description;
    }

    public Conference() {
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

    public String getIdOrganizer() {
        return idOrganizer;
    }

    public void setIdOrganizer(String idOrganizer) {
        this.idOrganizer = idOrganizer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}