package co.edu.unicauca.conferencemicroservice.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ListArticleConferenceDTO {
    private ConferenceDTO   conference;
    private int             cantArticles;
    private List<ArticleDTO>articles;
    public ListArticleConferenceDTO() {}
}
