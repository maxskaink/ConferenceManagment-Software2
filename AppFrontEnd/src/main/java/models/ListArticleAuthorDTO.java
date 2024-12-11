package models;
import java.util.List;
public class ListArticleAuthorDTO {
    private String author;
    private int totalArticles;
    private List<Article> articles;

    public  ListArticleAuthorDTO(){

    }

    public ListArticleAuthorDTO(String author, int totalArticles, List<Article> articles) {
        this.articles = articles;
        this.author = author;
        this.totalArticles = totalArticles;
    }


    /**
     * Get of Author
     *
     * @return String Name of author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author String name Author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return int total of araticles
     */
    public int getTotalArticles() {
        return totalArticles;
    }

    /**
     * @param totalArticles int total of Articles
     */
    public void setTotalArticles(int totalArticles) {
        this.totalArticles = totalArticles;
    }

    /**
     * @return List<Articles> list of articles of Author
     */
    public List<Article> getArticles() {
        return articles;
    }

    /**
     * @param articles list of Articles
     */
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }




}
