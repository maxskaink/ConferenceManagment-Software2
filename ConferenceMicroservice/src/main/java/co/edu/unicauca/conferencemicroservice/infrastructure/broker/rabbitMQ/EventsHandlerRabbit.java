package co.edu.unicauca.conferencemicroservice.infrastructure.broker.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.conferencemicroservice.application.port.out.IEventsHandler;
import co.edu.unicauca.conferencemicroservice.domain.model.Article;
import co.edu.unicauca.conferencemicroservice.domain.model.Conference;

@Service
public class EventsHandlerRabbit implements IEventsHandler {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public EventsHandlerRabbit(
            RabbitTemplate rabbitTemplate
    ){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendConference(Conference conference) {
        rabbitTemplate.convertAndSend(
                ConfigRabbit.EXCHANGE_NAME,
                ConfigRabbit.CONFERENCE_ROUTING_KEY,
                conference
        );
        System.out.println("Conference has been sent to the broker");    }

    @Override
    public void sendArticle(Article article) {
        rabbitTemplate.convertAndSend(
                ConfigRabbit.EXCHANGE_NAME,
                ConfigRabbit.ARTICLE_ROUTING_KEY,
                article
        );
        System.out.println("Article has been sent to the broker");
    }
}