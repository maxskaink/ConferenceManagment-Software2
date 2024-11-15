package java.co.edu.unicauca.conferencemicroservice.application.port.out;

import java.co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Conference;

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

    /**
     * Listen the queue for users
     */
    void listenUsers();
}
