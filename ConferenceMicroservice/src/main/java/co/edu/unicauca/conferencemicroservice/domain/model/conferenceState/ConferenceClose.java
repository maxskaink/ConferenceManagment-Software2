package co.edu.unicauca.conferencemicroservice.domain.model.conferenceState;

import co.edu.unicauca.conferencemicroservice.domain.exception.Unauthorized;
import co.edu.unicauca.conferencemicroservice.domain.model.Article;
import co.edu.unicauca.conferencemicroservice.domain.model.valueObjects.BasicDate;

public class ConferenceClose implements IConferenceState{
    @Override
    public Article createArticle(String idAuthor, String idArticle, String name, String keyWords, BasicDate publishDate, String idConferencce) {
        throw new Unauthorized("Conference close, its impossible to create article");
    }
}
