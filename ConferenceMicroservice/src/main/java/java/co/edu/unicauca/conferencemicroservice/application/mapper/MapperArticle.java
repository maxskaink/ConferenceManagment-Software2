package java.co.edu.unicauca.conferencemicroservice.application.mapper;

import java.co.edu.unicauca.conferencemicroservice.application.dto.ArticleDTO;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Article;

public class MapperArticle {
    public static ArticleDTO toArticleDTO(Article article){
        return new ArticleDTO(
                article.getId(),
                article.getName(),
                article.getIdAuthor(),
                article.getKeyWords(),
                article.getPublishDate(),
                article.getIdConference()
        );
    }
}
