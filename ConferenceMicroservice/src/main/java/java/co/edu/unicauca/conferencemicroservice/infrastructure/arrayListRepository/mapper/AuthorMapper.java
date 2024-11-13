package java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.mapper;

import java.co.edu.unicauca.conferencemicroservice.domain.model.Author;
import java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity.AuthorEntity;

public class AuthorMapper {
    /**
     * Map an instance of Author to Author entity
     * @param author author to map
     * @return instance of AuthorEntity
     */
    public static AuthorEntity toAuthorEntity(Author author) {
        return new AuthorEntity(
                author.getId(),
                author.getName(),
                author.getEmail(),
                true
        );
    }

    /**
     * Map an instace of AuthorEntity to Author
     * @param entity Entity to map
     * @return instance of author
     */
    public static Author toAuthor(AuthorEntity entity) {
        return new Author(
                entity.getId(),
                entity.getName(),
                entity.getEmail()
        );
    }
}