package java.co.edu.unicauca.conferencemicroservice.application.builder;

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
