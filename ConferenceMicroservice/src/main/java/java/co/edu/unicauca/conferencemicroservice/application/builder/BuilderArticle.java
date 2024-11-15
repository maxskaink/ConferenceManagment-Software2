package java.co.edu.unicauca.conferencemicroservice.application.builder;

import java.co.edu.unicauca.conferencemicroservice.application.dto.ArticleDTO;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IAuthorRepository;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IConferenceRepository;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.Unauthorized;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Author;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Conference;
import java.util.UUID;

public class BuilderArticle implements IBuilderArticle{
    private Conference conference;
    private Author author;
    private final ArticleDTO articleDTO;

    private final IConferenceRepository conferenceRepository;
    private final IAuthorRepository authorRepository;

    public BuilderArticle(ArticleDTO articleDTO, IAuthorRepository authorRepository, IConferenceRepository conferenceRepository){
        this.conferenceRepository = conferenceRepository;
        this.authorRepository = authorRepository;
        this.articleDTO = articleDTO;
    }

    @Override
    public void validateAuthor() {
        //Validate the existence of author
        try{
            author = authorRepository.findById(articleDTO.getIdAuthor());
        }catch (NotFound e){
            throw new Unauthorized("Just an author can add an article");
        }
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
                author,
                articleDTO.getId(),
                articleDTO.getName(),
                articleDTO.getKeyWords(),
                articleDTO.getPublishDate()
        );
    }
}
