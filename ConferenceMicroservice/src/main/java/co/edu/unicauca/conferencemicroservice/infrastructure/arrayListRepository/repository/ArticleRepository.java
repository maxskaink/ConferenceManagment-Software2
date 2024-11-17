package co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.repository;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.conferencemicroservice.domain.exception.DuplicateInformation;
import co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import co.edu.unicauca.conferencemicroservice.domain.model.Article;
import co.edu.unicauca.conferencemicroservice.application.port.out.IArticleRepository;
import co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity.ArticleEntity;
import co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity.BasicDateEntity;
import co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.mapper.ArticleMapper;
import co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.mapper.BasicDateMapper;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository implements IArticleRepository {

    private final List<ArticleEntity> articles;

    public ArticleRepository() {
        articles = new ArrayList<ArticleEntity>();

        generateBaseInfo();
    }

    @Override
    public Article saveArticle(Article article) throws DuplicateInformation {

        for(ArticleEntity articleEntity : articles)
            if(articleEntity.getId().equals(article.getId()))
                throw new DuplicateInformation("User with id" + article.getId() + " already exists");

        this.articles.add( ArticleMapper.toArticleEntity(article) );

        return article;
    }

    @Override
    public List<Article> findAllArticles() {
        List<Article> listArticles = new ArrayList<>();

        for(ArticleEntity articleEntity : articles)
            listArticles.add(ArticleMapper.toArticle(articleEntity));

        return listArticles;
    }

    @Override
    public Article findArticleById(String id) throws NotFound {
        for(ArticleEntity articleEntity : articles)
            if(articleEntity.getId().equals(id))
                return ArticleMapper.toArticle(articleEntity);
        throw new NotFound("Article with id" + id + " not found");
    }

    @Override
    public List<Article> findArticleByAuthor(String idAuthor) {
        List<Article> listArticles = new ArrayList<>();

        for(ArticleEntity articleEntity : articles)
            if(articleEntity.getIdAuthor().equals(idAuthor))
                listArticles.add(ArticleMapper.toArticle(articleEntity));

        return listArticles;
    }

    @Override
    public Article deleteArticleById(String id) throws NotFound {

        for(ArticleEntity articleEntity : articles){
            if(articleEntity.getId().equals(id)){
                articles.remove(articleEntity);
                return ArticleMapper.toArticle(articleEntity);
            }
        }

        throw new NotFound("Article with id" + id + " not found");
    }

    @Override
    public Article updateArticle(Article article) throws DuplicateInformation {
        ArticleEntity articleFodunded = null;

        for(ArticleEntity articleEntity : articles)
            if(articleEntity.getId().equals(article.getId()))
                articleFodunded = articleEntity;

        if(articleFodunded == null)
            throw new DuplicateInformation("User with id" + article.getId() + " already exists");

        articleFodunded.setName( article.getName() );
        articleFodunded.setName( articleFodunded.getName() );
        articleFodunded.setPublicationDate(BasicDateMapper.toBasicDateEntity( article.getPublishDate() ));

        return ArticleMapper.toArticle(articleFodunded);
    }

    private void generateBaseInfo(){
        articles.add(new ArticleEntity("1234", "Conference 1", "1111", "important", new BasicDateEntity(16,8,2024), "9876"));
        articles.add(new ArticleEntity("1235", "Conference 2", "1111", "important", new BasicDateEntity(16,8,2024), "9876"));
        articles.add(new ArticleEntity("1236", "Conference 3", "2222", "important", new BasicDateEntity(16,8,2024), "9876"));
        articles.add(new ArticleEntity("1237", "Conference 4", "2222", "important", new BasicDateEntity(16,8,2024), "9876"));
    }
}
