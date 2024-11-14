package java.co.edu.unicauca.conferencemicroservice.domain.model;

import org.yaml.snakeyaml.events.Event;

import java.co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import java.co.edu.unicauca.conferencemicroservice.domain.model.valueObjects.BasicDate;
import java.util.regex.Pattern;

public class Author {
    private String id;
    private String name;
    private String email;

    /**
     * Main constructor of Author, if some values is invalid throws
     * InvalidValue exception
     * @param id must be not null or empty
     * @param name must be not null or empty
     * @param email must be not null or empty, and it msu have an email format
     */
    public Author(String id, String name, String email) {
        //Validate information
        validateName(name);
        validateEmail(email);
        validateID(id);
        //Assing values
        this.id=id;
        this.name=name;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {return email;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        validateID(id);
        this.id = id;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public Article createArticle(
            String id,
            String name,
            String keyWords,
            BasicDate publishDate
    ){
        return new Article(id, name, this.id, keyWords, publishDate);
    }

    private void validateName(String name){
        if(name == null || name.isEmpty())
            throw new InvalidValue("Name cannot be null or empty");
    }

    private void validateID(String id){
        if(id == null || id.isEmpty())
            throw new InvalidValue("ID cannot be null or empty");
    }

    private void validateEmail(String email){
        //Validate is not null or empty
        if(email == null || email.isEmpty())
            throw new InvalidValue("Email cannot be null or empty");

        //Start validation is an email
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        if(!EMAIL_PATTERN.matcher(email).matches())
            throw new InvalidValue("Email does not have the correct format");

    }

}
