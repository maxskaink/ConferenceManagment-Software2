package co.edu.unicauca.Microservicio.de.evaluacion.services.DTO;

public class ArticleDTO {
    private String id;
    private String name;
    private String idAuthor;
    private String keyWords;
    private BasicDate publishDate;
    private String idConference;

    /**
     * Main constructor of Article class, if some value is invalid throw InvalidValue
     * @param id must be not null or empty
     * @param name must be not null or empty
     * @param idAuthor must be not null or empty
     * @param keyWords must be not null or empty
     * @param publishDate must be a real date
     */
    public ArticleDTO(String id, String name, String idAuthor, String keyWords, String idConference,BasicDate publishDate) {
        this.id = id;
        this.name = name;
        this.idAuthor = idAuthor;
        this.keyWords = keyWords;
        this.publishDate = publishDate;
        this.idConference = idConference;
    }
    public String getId() {return id;}
    public String getName() {return name;}
    public String getIdAuthor() {return idAuthor;}
    public String getIdConference() {return idConference;}
    public String getKeyWords() {return keyWords;}
    public void setId(String id) {this.id = id;}
    public BasicDate getPublishDate() {return publishDate;}
    public void setName(String name) {this.name = name;}
    public void setIdAuthor(String idAuthor) {this.idAuthor = idAuthor;}
    public void setKeyWords(String keyWords) {this.keyWords = keyWords;}
    public void setPublishDate(BasicDate publishDate) {this.publishDate = publishDate;}
    public void setIdConference(String conference) {
        this.idConference = conference;
    }



}
