package co.edu.unicauca.Microservicio.de.evaluacion.dao;

import co.edu.unicauca.Microservicio.de.evaluacion.domain.Article;

public interface IArticleRepository {
    /***
     *
     * @param article article to save
     * @return article save
     */
    Article  save(Article article);

    /**
     *
     * @param id id of Article to find
     * @return  Article find
     */
    Article findById(String id);
}
