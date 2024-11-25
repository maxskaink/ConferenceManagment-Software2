package co.edu.unicauca.conferencemicroservice.domain.model.conferenceState;

import co.edu.unicauca.conferencemicroservice.domain.model.Article;
import co.edu.unicauca.conferencemicroservice.domain.model.valueObjects.BasicDate;

public class ConferenceOpen implements IConferenceState{
    @Override
    public Article createArticle(String idAuthor, String idArticle, String name, String keyWords, BasicDate publishDate, String idConferencce) {
        return new Article(
                idArticle,
                name,
                idAuthor,
                keyWords,
                idConferencce,
                publishDate
        );
    }
}
