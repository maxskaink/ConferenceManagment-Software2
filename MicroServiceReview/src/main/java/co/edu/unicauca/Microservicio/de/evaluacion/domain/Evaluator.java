/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.domain;
import java.util.List;


public class Evaluator {
    private String id;
    private String name;
    private String email;
    private List<Article> articles;
    public Evaluator() {
        
    }
    public Evaluator(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Evaluator(String id, String name, String email, List<Article> articles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.articles = articles;
    }
    
    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Article addArticle(Article article) {
        this.articles.add(article);
        return article;
    }

}