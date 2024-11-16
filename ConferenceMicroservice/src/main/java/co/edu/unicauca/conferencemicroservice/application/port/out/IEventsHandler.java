package co.edu.unicauca.conferencemicroservice.application.port.out;

import co.edu.unicauca.conferencemicroservice.domain.model.Article;
import co.edu.unicauca.conferencemicroservice.domain.model.Conference;

public interface IEventsHandler {
    /**
     * Send a create conference event
     * @param conference conference to send
     */
    void sendConference(Conference conference);

    /**
     * Send a create article event
     * @param article article to send
     */
    void sendArticle(Article article);
}
