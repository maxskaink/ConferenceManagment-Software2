package co.edu.unicauca.conferencemicroservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import co.edu.unicauca.conferencemicroservice.domain.model.valueObjects.BasicDate;

@Setter
@Getter
@AllArgsConstructor
public class ArticleDTO {
    private String      id;
    private String      name;
    private String      idAuthor;
    private String      keyWords;
    private BasicDate   publishDate;
    private String      idConference;
    public ArticleDTO(){}
}
