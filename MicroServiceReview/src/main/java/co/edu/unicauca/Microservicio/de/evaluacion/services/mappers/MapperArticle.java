package co.edu.unicauca.Microservicio.de.evaluacion.services.mappers;

import co.edu.unicauca.Microservicio.de.evaluacion.domain.Article;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Evaluator;
import co.edu.unicauca.Microservicio.de.evaluacion.services.DTO.ArticleDTO;

import java.util.ArrayList;

public class MapperArticle {
    ArrayList<Evaluator> evaluators= new ArrayList();
    public Article mapperToArticle(ArticleDTO article) {

        Article articleTosave = new Article(
                article.getId(),
                article.getName(),
                article.getIdAuthor(),
                article.getKeyWords(),
                evaluators
        );
        return articleTosave;
    }
}
