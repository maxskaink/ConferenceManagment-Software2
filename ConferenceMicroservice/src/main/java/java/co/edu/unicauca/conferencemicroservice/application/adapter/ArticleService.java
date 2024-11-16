package java.co.edu.unicauca.conferencemicroservice.application.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.co.edu.unicauca.conferencemicroservice.application.builder.BuilderArticle;
import java.co.edu.unicauca.conferencemicroservice.application.builder.DirectorBuilderArticle;
import java.co.edu.unicauca.conferencemicroservice.application.dto.ArticleDTO;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IConferenceRepository;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.Unauthorized;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.co.edu.unicauca.conferencemicroservice.application.port.in.IArticleService;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IArticleRepository;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IEventsHandler;
import java.util.List;

@Service
public class ArticleService implements IArticleService {

    private final IArticleRepository articleRepository;
    private final IConferenceRepository conferenceRepository;
    private final IEventsHandler eventsHandler;

    @Autowired
    public ArticleService(
            IArticleRepository repository,
            IConferenceRepository conferenceRepository,
            IEventsHandler eventsHandler
    ){
        this.articleRepository = repository;
        this.conferenceRepository = conferenceRepository;
        this.eventsHandler = eventsHandler;
    }

    @Override
    public Article save(ArticleDTO article) {
        if(article == null)
            throw new InvalidValue("Need an instance of article");

        //instance of builder and create the article
        BuilderArticle builder = new BuilderArticle(
                article,
                conferenceRepository
        );
        DirectorBuilderArticle director = new DirectorBuilderArticle( builder );

        director.makeArticle();

        Article newArticle = builder.getResult();

        //Save the article
        Article articleCreated = articleRepository.saveArticle(newArticle);
        //Notify an event
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
    public Article update(String id, ArticleDTO article) throws InvalidValue, NotFound {
        if(id==null)
            throw new InvalidValue("Id null is invalid");
        if(article == null)
            throw new InvalidValue("Need an instance of article");

        article.setId(id);
        Article articleExist = findArticleByID(id);
        if(!articleExist.getIdAuthor().equals(article.getIdAuthor()))
            throw new Unauthorized("The author is no owner of the article");

        //instance of builder and create the article
        BuilderArticle builder = new BuilderArticle(
                article,
                conferenceRepository
        );
        DirectorBuilderArticle director = new DirectorBuilderArticle( builder );

        director.makeArticleWithoutID();

        Article newArticle = builder.getResult();

        //Save the changes of the new article
        Article articleUpdated = this.articleRepository.updateArticle(newArticle);
        //Notify the event
        eventsHandler.sendArticle(newArticle);

        return articleUpdated;
    }

    @Override
    public Article delete(String id) throws InvalidValue {

        if(id==null)
            throw new InvalidValue("Id null is not valid");

        return articleRepository.deleteArticleById(id);
    }

    //TODO check this functin in detail
    @Override
    public Article exist(String id) throws NotFound {
        return null;
    }
}
