package co.edu.unicauca.conferencemicroservice.domain.builder;

public interface IBuilderArticle {
    /**
     * Validate the existence of the conference and if it is available
     */
    void validateConference();

    /**
     * Generate the ID of the article
     */
    void generateID();
}
