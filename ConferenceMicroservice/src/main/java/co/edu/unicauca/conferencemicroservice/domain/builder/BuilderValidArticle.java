package co.edu.unicauca.conferencemicroservice.domain.builder;

import co.edu.unicauca.conferencemicroservice.application.port.out.IConferenceRepository;
import co.edu.unicauca.conferencemicroservice.domain.model.Article;
import co.edu.unicauca.conferencemicroservice.domain.model.Conference;
import java.util.UUID;

public class BuilderValidArticle implements IBuilderArticle{
    private Conference conference;
    private final Article article;

    private final IConferenceRepository conferenceRepository;

    public BuilderValidArticle(Article article, IConferenceRepository conferenceRepository){
        this.conferenceRepository = conferenceRepository;
        this.article = article;
    }

    @Override
    public void validateConference() {
        //Validate the existence of conference
        //TODO validate conference status
        conference = conferenceRepository.findById(article.getIdConference());
    }

    @Override
    public void generateID() {
        //Generate an ID
        article.setId(UUID.randomUUID().toString());
    }

    public Article getResult(){
        return conference.createArticle(
                article.getIdAuthor(),
                article.getId(),
                article.getName(),
                article.getKeyWords(),
                article.getPublishDate()
        );
    }
}