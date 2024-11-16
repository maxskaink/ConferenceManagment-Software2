package co.edu.unicauca.conferencemicroservice.infrastructure.broker.rabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRabbit {
    // Nombre de las colas
    public static final String CONFERENCE_QUEUE = "conferenceQueue";
    public static final String ARTICLE_QUEUE = "articleQueue";

    // Nombre del intercambio
    public static final String EXCHANGE_NAME = "myExchange";

    // Claves de enrutamiento
    public static final String CONFERENCE_ROUTING_KEY = "conferenceRoutingKey";
    public static final String ARTICLE_ROUTING_KEY = "articleRoutingKey";

    @Bean
    public Queue conferenceQueue() {
        return new Queue(CONFERENCE_QUEUE, true);
    }

    @Bean
    public Queue articleQueue() {
        return new Queue(ARTICLE_QUEUE, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding conferenceBinding(Queue conferenceQueue, DirectExchange exchange) {
        return BindingBuilder.bind(conferenceQueue).to(exchange).with(CONFERENCE_ROUTING_KEY);
    }

    @Bean
    public Binding articleBinding(Queue articleQueue, DirectExchange exchange) {
        return BindingBuilder.bind(articleQueue).to(exchange).with(ARTICLE_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
}
