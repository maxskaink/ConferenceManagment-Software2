package co.edu.unicauca.conferencemicroservice.infrastructure.mapper;

import co.edu.unicauca.conferencemicroservice.infrastructure.dto.ArticleDTO;
import co.edu.unicauca.conferencemicroservice.domain.model.Article;

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
    public static Article toArticle(ArticleDTO articleDTO){
        return new Article(
            articleDTO.getId(),
                articleDTO.getName(),
                articleDTO.getIdAuthor(),
                articleDTO.getKeyWords(),
                articleDTO.getIdConference(),
                articleDTO.getPublishDate()
        );
    }
}