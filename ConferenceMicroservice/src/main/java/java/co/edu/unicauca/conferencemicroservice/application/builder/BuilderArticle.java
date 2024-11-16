package java.co.edu.unicauca.conferencemicroservice.application.builder;

import java.co.edu.unicauca.conferencemicroservice.application.dto.ArticleDTO;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IConferenceRepository;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Conference;
import java.util.UUID;

public class BuilderArticle implements IBuilderArticle{
    private Conference conference;
    private final ArticleDTO articleDTO;

    private final IConferenceRepository conferenceRepository;

    public BuilderArticle(ArticleDTO articleDTO, IConferenceRepository conferenceRepository){
        this.conferenceRepository = conferenceRepository;
        this.articleDTO = articleDTO;
    }

    @Override
    public void validateConference() {
        //Validate the existence of conference
        //TODO validate conference status
        conference = conferenceRepository.findById(articleDTO.getIdConference());
    }

    @Override
    public void generateID() {
        //Generate an ID
        articleDTO.setId(UUID.randomUUID().toString());
    }

    public Article getResult(){
        return conference.createArticle(
                articleDTO.getIdAuthor(),
                articleDTO.getId(),
                articleDTO.getName(),
                articleDTO.getKeyWords(),
                articleDTO.getPublishDate()
        );
    }
}
