/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author isabe
 */
public class ArticleDTO {
    private String      id;
    private String      name;
    private String      idAuthor;
    private String      keyWords;
    private BasicDate   publishDate;
    private String      idConference;

    public ArticleDTO() {
    }

    public ArticleDTO(String id, String name, String idAuthor, String keyWords, BasicDate publishDate, String idConference) {
        this.id = id;
        this.name = name;
        this.idAuthor = idAuthor;
        this.keyWords = keyWords;
        this.publishDate = publishDate;
        this.idConference = idConference;
    }
    
    public ArticleDTO(String name, String idAuthor, String keyWords, BasicDate publishDate, String idConference) {
        this.name = name;
        this.idAuthor = idAuthor;
        this.keyWords = keyWords;
        this.publishDate = publishDate;
        this.idConference = idConference;
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

    public String getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(String idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public BasicDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(BasicDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getIdConference() {
        return idConference;
    }

    public void setIdConference(String idConference) {
        this.idConference = idConference;
    }

    
}
