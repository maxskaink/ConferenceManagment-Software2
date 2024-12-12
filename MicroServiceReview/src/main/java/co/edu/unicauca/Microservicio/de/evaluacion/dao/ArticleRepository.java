/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.Microservicio.de.evaluacion.dao;

import co.edu.unicauca.Microservicio.de.evaluacion.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ismos
 */
@Repository
public class ArticleRepository implements  IArticleRepository{

    private final List<Article> articles;

    public ArticleRepository() {
        articles = new ArrayList<Article>();
        articles.add(new Article("1000", "Juan", "100002", "allg", new ArrayList<>()));
        articles.add(new Article("1001", "Camilo", "100003", "allg", new ArrayList<>()));
    }   

    @Override
    public Article save(Article article) {
        if(articles.add(article))
            return article;
        return null;
    }

    @Override
    public Article findById(String id) {
        for(Article articleEntity : articles)
            if(articleEntity.getId().equals(id))
                return articleEntity;
        return null;
    }
}
