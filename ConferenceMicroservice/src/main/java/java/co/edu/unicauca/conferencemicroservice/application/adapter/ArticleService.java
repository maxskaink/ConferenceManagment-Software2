package java.co.edu.unicauca.conferencemicroservice.application.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.co.edu.unicauca.conferencemicroservice.domain.port.in.IArticleService;
import java.co.edu.unicauca.conferencemicroservice.domain.port.out.IArticleRepository;
import java.co.edu.unicauca.conferencemicroservice.domain.port.out.IEventsHandler;
import java.util.List;

@Service
public class ArticleService implements IArticleService {

    private final IArticleRepository articleRepository;
    private final IEventsHandler eventsHandler;

    @Autowired
    public ArticleService( IArticleRepository repository, IEventsHandler eventsHandler){
        this.articleRepository = repository;
        this.eventsHandler = eventsHandler;
    }

    @Override
    public Article save(Article article) {
        if(article == null)
            throw new InvalidValue("Need an instance of article");

        Article articleCreated = articleRepository.saveArticle(article);

        eventsHandler.sendArticle(articleCreated);

        return articleCreated;
    }

    @Override
    public List<Article> findArticleByConference(String id) {

        if(id == null)
            throw new InvalidValue("Id null not valid");
        List<Article> allArticles = articleRepository.findAllArticles();

        allArticles.removeIf(singleArticle -> !singleArticle.getIdConference().equals(id));

        return allArticles;
    }

    @Override
    public List<Article> findArticleByAuthor(String idAuthor) {
        if(idAuthor==null)
            throw new InvalidValue("idAuthor null not valid");

        return articleRepository.findArticleByAuthor(idAuthor);
    }

    @Override
    public Article findArticleByID(String id) throws NotFound {
        if(id==null)
            throw new InvalidValue("id null not valid");

        return articleRepository.findArticleById(id);
    }

    @Override
    public Article update(String id, Article article) throws InvalidValue, NotFound {
        if(id==null)
            throw new InvalidValue("Id null is invalid");
        if(article == null)
            throw new InvalidValue("Need an instance of article");

        article.setId(id);
        Article articleUpdated = this.articleRepository.updateArticle(article);

        eventsHandler.sendArticle(article);

        return articleUpdated;
    }

    @Override
    public Article delete(String id) throws InvalidValue {

        if(id==null)
            throw new InvalidValue("Id null is not valid");

        return articleRepository.deleteArticleById(id);
    }

    //TODO revisar esta funcion mas a detalle
    @Override
    public Article exist(String id) throws NotFound {
        return null;
    }
}
