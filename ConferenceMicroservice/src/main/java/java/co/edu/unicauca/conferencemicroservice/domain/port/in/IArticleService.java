package java.co.edu.unicauca.conferencemicroservice.domain.port.in;

import java.co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.util.List;

public interface IArticleService {
    Article save(Article article);
    List<Article> findArticleByConference(String id);
    List<Article> findArticleByAuthor(String idAuthor);
    Article findArticleByID(String id) throws NotFound;
    Article update(String id, Article article)  throws InvalidValue, NotFound;
    Article delete(String id) throws InvalidValue;
    Article exist(String id) throws NotFound;
}
