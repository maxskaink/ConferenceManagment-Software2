package java.co.edu.unicauca.conferencemicroservice.domain.port.out;

import java.co.edu.unicauca.conferencemicroservice.domain.exception.DuplicateInformation;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.util.List;

public interface IArticleRepository {
    /**
     * save an article in database
     * @param article article to save
     * @return article saved in db
     */
    Article saveArticle(Article article) throws DuplicateInformation;

    /**
     * Find all the articles in db
     * @return List of articles in db
     */
    List<Article> findAllArticles();

    /**
     * Find an article by id if not exist throw an NotFound Exception
     * @param id ID to search
     * @return the article with id
     */
    Article findArticleById(String id) throws NotFound;

    /**
     * Find articles with id of the author
     * @param idAuthor id of the author to search
     * @return the list of authors
     */
    List<Article> findArticleByAuthor(String idAuthor);

    /**
     * Delete an article with idArticle, if it not exist throw an
     * NotFound Exceptiion
     * @param id id of the Article
     * @return The deleted Artile
     */
    Article deleteArticleById(String id) throws NotFound;

    /**
     * Update an article, if the id doesn't exist it throw
     * A NotFound Exception
     * @param article Article to update, important de id is valid
     * @return The updated article
     */
    Article updateArticle(Article article) throws DuplicateInformation;
}
