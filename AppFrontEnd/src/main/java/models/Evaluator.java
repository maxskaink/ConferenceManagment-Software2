package models;

import java.util.List;

public class Evaluator {
    private String id;
    private String name;
    private String email;
    private List<Article> articles;

    // Constructor por defecto
    public Evaluator() {
    }

    // Constructor con parámetros
    public Evaluator(String id, String name, String email, List<Article> articles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.articles = articles;
    }

    // Getters y Setters
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

    // Método toString (opcional, útil para depuración)
    @Override
    public String toString() {
        return "Evaluator{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", articles=" + articles +
                '}';
    }
}

