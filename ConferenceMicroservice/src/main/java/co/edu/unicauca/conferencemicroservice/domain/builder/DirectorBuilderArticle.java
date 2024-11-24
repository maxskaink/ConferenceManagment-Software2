package co.edu.unicauca.conferencemicroservice.domain.builder;

public class DirectorBuilderArticle {
    private IBuilderArticle builder;

    /**
     * Create an instance of DirectorBuilderArticle
     * @param builder builder to use
     */
    public DirectorBuilderArticle( IBuilderArticle builder){
        this.builder = builder;
    }

    /**
     * Change the builder for the director
     * @param builder new builder to use
     */
    public void changeBuilder(IBuilderArticle builder){
        this.builder = builder;
    }

    /**
     * Make an article, also generate a new UUID for the article
     */
    public void makeArticle(){
        builder.validateConference();
        builder.generateID();
    }
    /**
     * Make an article, but not generate UUID for the article,
     * it will use the DTO id
     */
    public void makeArticleWithDTO(){
        builder.validateConference();
    }
}
