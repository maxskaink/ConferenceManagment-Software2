package co.edu.unicauca.conferencemicroservice.application.port.in;

import co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.util.List;

public interface IArticleService {
    /**
     * Save an article in db and publish the event
     * @param article article to save
     * @return the article saved
     */
    Article save(Article article);

    /**
     * Find article in db by ID of the conference
     * @param id id to the conference to search
     * @return article found
     */
    List<Article> findArticleByConference(String id);

    /**
     * Find article by id author
     * @param idAuthor id author to search
     * @return article found
     */
    List<Article> findArticleByAuthor(String idAuthor);

    /**
     * Find Article by id
     * @param id id of the article to find
     * @return article found
     * @throws NotFound if the article doesn't exist
     */
    Article findArticleByID(String id) throws NotFound;

    /**
     * Update an article in db and publish an event
     * @param id id of the article to update
     * @param article new article
     * @return new article updated
     * @throws InvalidValue if some info is invalid
     * @throws NotFound if the id doesn't exist
     */
    Article update(String id, Article article)  throws InvalidValue, NotFound;

    /**
     * Delete an article in db
     * @param id id of the article to delete
     * @return the article deleted
     * @throws InvalidValue if some value is invalid
     */
    Article delete(String id) throws InvalidValue;

    /**
     * Verify if some article exist
     * @param id id to search
     * @return return the article found
     * @throws NotFound if the article doesn't exist
     */
    Article exist(String id) throws NotFound;
}
