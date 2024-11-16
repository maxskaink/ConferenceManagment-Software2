package java.co.edu.unicauca.conferencemicroservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ListArticleConferenceDTO {
    private ConferenceDTO   conferenceOutDTO;
    private int             cantArticles;
    private List<ArticleDTO>articles;
    public ListArticleConferenceDTO() {}
}
