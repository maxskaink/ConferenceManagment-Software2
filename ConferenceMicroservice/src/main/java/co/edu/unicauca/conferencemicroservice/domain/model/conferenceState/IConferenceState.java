package co.edu.unicauca.conferencemicroservice.domain.model.conferenceState;

import co.edu.unicauca.conferencemicroservice.domain.model.Article;
import co.edu.unicauca.conferencemicroservice.domain.model.valueObjects.BasicDate;

public interface IConferenceState {
    /**
     * Create an instance of an article
     * @param idAuthor id of the author
     * @param idArticle id of the article
     * @param name name of the article
     * @param keyWords keyword of the article
     * @param publishDate publishDate of the article
     * @param idConferencce id of the conference
     * @return an instance of the article
     */
    Article createArticle(
            String idAuthor,
            String idArticle,
            String name,
            String keyWords,
            BasicDate publishDate,
            String idConferencce

    );
}
