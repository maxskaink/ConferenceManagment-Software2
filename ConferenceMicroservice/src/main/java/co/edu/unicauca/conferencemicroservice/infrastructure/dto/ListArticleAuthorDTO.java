package co.edu.unicauca.conferencemicroservice.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ListArticleAuthorDTO {
    private String          author;
    private int             totalArticles;
    private List<ArticleDTO>articles;
    public ListArticleAuthorDTO() {}
}
