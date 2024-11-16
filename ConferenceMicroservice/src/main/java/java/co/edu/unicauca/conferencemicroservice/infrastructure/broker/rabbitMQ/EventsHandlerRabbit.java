package java.co.edu.unicauca.conferencemicroservice.infrastructure.broker.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.co.edu.unicauca.conferencemicroservice.application.port.out.IEventsHandler;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Conference;

@Service
public class EventsHandlerRabbit implements IEventsHandler {

    private final AmqpTemplate amqpTemplate;
    private final String exchange = "myExchange";
    private final String routingKey = "routingKey";

    @Autowired
    public EventsHandlerRabbit(
            AmqpTemplate amqpTemplate
    ){
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void sendConference(Conference conference) {
        //amqpTemplate.convertAndSend(exchange, routingKey, objClienteCreado);
        System.out.println("Has been sent a conference to the broker");
    }

    @Override
    public void sendArticle(Article article) {
        System.out.println("Hass been sent a article to the broker");
    }
}
