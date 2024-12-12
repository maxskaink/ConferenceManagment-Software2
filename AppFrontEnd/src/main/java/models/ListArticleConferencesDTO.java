package models;

import java.util.ArrayList;
import java.util.List;

public class ListArticleConferencesDTO {
    private Conference conference;
    private int cantArticles;
    List<Article> articles;

    public ListArticleConferencesDTO(Conference conference, int cantArticles) {
        this.conference = conference;
        this.cantArticles = cantArticles;
        this.articles = new ArrayList<Article>();
    }
    public  ListArticleConferencesDTO(){

    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public int getCantArticles() {
        return cantArticles;
    }

    public void setCantArticles(int cantArticles) {
        this.cantArticles = cantArticles;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
