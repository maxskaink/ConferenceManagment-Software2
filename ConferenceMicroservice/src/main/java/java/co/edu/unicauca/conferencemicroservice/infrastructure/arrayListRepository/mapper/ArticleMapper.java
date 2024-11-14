package java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.mapper;

import java.co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity.ArticleEntity;

public class ArticleMapper {
    /**
     * Create an instance of article entity based on article
     * @param article info base to transform
     * @return an instance of article entity
     */
    public static ArticleEntity toArticleEntity(Article article) {
        return new ArticleEntity(
                article.getId(),
                article.getName(),
                article.getIdAuthor(),
                article.getKeyWords(),
                BasicDateMapper.toBasicDateEntity(article.getPublishDate()),
                article.getIdConference()
        );
    }

    /**
     * Create an instance of article based on articleEntity
     * @param articleEntity info base to create
     * @return Instance of article
     */
    public static Article toArticle(ArticleEntity articleEntity) {
        return new Article(
                articleEntity.getId(),
                articleEntity.getName(),
                articleEntity.getIdAuthor(),
                articleEntity.getKeywords(),
                BasicDateMapper.toBasicDate(articleEntity.getPublicationDate())
        );
    }
}
