package co.edu.unicauca.conferencemicroservice.infrastructure.configuration;

import co.edu.unicauca.conferencemicroservice.application.port.out.IArticleRepository;
import co.edu.unicauca.conferencemicroservice.application.port.out.IConferenceRepository;
import co.edu.unicauca.conferencemicroservice.application.port.out.IEventsHandler;
import co.edu.unicauca.conferencemicroservice.domain.useCase.ArticleService;
import co.edu.unicauca.conferencemicroservice.domain.useCase.ConferenceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ArticleService crearArticleService(
            IArticleRepository repository,
            IConferenceRepository conferenceRepository,
            IEventsHandler eventsHandler
    ) {
        return new ArticleService(
                repository,
                conferenceRepository,
                eventsHandler
        );
    }

    @Bean
    public ConferenceService crearConferenceService(
            IConferenceRepository repository,
            IEventsHandler even
    ){
        return new ConferenceService(
                repository,
                even
        );
    }
}
