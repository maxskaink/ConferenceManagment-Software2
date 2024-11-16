package java.co.edu.unicauca.conferencemicroservice.domain.model;

import java.co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import java.co.edu.unicauca.conferencemicroservice.domain.model.valueObjects.BasicDate;
public class Conference {
    private String id;
    private String name;
    private BasicDate startDate;
    private BasicDate finishDate;
    private String place;
    private String topic;
    private String idOrganizer;
    private String description;

    /**
     * Constructor of conference
     * @param name String name of conference
     * @param startDate BasicDate start date of conference
     * @param finishDate BasicDate finish date of conference
     * @param place String Place of conference
     * @param topic String topic of conference
     * @param idOrganizer idOrganizer to created conference
     * @param description String description of conference
     */
    public Conference(String id, String name, BasicDate startDate, BasicDate finishDate, String place, String topic, String idOrganizer, String description) {
        //Validate the values
        validateString("id", id);
        validateString("name",name);
        validateString("place ", place);
        validateString("topic", topic );
        validateString("description", description);
        //Assigns the values
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.place = place;
        this.topic = topic;
        this.idOrganizer = idOrganizer;
        this.description = description;
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

    /**
     * Create an instance of article
     * @param author Author how create de article
     * @param idArticle id of the new article
     * @param name name of the article
     * @param keyWords keyword of the article
     * @param publishDate date of article published
     * @return An instance of article
     */
    public Article createArticle(
            Author author,
            String idArticle,
            String name,
            String keyWords,
            BasicDate publishDate

    ){
        return new Article(
                idArticle,
                name,
                author.getId(),
                keyWords,
                this.getId(),
                publishDate
        );
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
