package java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.repository;

import org.springframework.stereotype.Repository;

import java.co.edu.unicauca.conferencemicroservice.domain.exception.DuplicateInformation;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Author;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IAuthorRepository;
import java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity.AuthorEntity;
import java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.mapper.AuthorMapper;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository implements IAuthorRepository {

    private final List<AuthorEntity> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<AuthorEntity>();
    }

    @Override
    public Author findById(String id) throws NotFound {
        for(AuthorEntity author : authors)
            if(author.getId().equals(id))
                return AuthorMapper.toAuthor(author);
        throw new NotFound("User with id "+ id + " not found");
    }

    @Override
    public List<Author> findAllAuthors() {
        List<Author> auhtorsFounded = new ArrayList<>();

        for(AuthorEntity author : authors)
            auhtorsFounded.add(AuthorMapper.toAuthor(author));

        return auhtorsFounded;
    }

    @Override
    public Author saveAuthor(Author author) throws DuplicateInformation {

        for(AuthorEntity authorEntity : authors)
            if(authorEntity.getId().equals(author.getId()))
                throw new DuplicateInformation("User with id "+ author.getId() + " already exists");

        authors.add(AuthorMapper.toAuthorEntity(author));
        return author;
    }

    @Override
    public Author deleteAuthor(String idAuthor) throws NotFound {

        for(AuthorEntity author : authors){
            if(author.getId().equals(idAuthor))
                authors.remove(author);
            return AuthorMapper.toAuthor(author);
        }

        throw new NotFound("User with id "+ idAuthor + " not exist");
    }

    private void generateBaseInfo(){
        authors.add( new AuthorEntity("1111", "Miguel", "mangelcvivas@unicauca.edu.co", true) );
        authors.add( new AuthorEntity("2222", "Santiago", "scandon@unicauca.edu.co", true) );
    }
}
