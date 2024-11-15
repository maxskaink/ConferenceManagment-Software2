package java.co.edu.unicauca.conferencemicroservice.application.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.co.edu.unicauca.conferencemicroservice.application.dto.UserDTO;
import java.co.edu.unicauca.conferencemicroservice.application.mapper.MapperUserDTO;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Author;
import java.co.edu.unicauca.conferencemicroservice.application.port.in.IAuthorService;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IAuthorRepository;

@Service
public class AuthorService implements IAuthorService {

    private final IAuthorRepository authorRepository;

    @Autowired
    public AuthorService(IAuthorRepository repository){
        this.authorRepository = repository;
    }

    @Override
    public Author save(UserDTO userDTO) {
        if(userDTO ==null)
            throw new InvalidValue("null authorToSave is invalid");

        return authorRepository.saveAuthor(MapperUserDTO.toAuthor(userDTO));
    }

    @Override
    public Author deleteById(String id) throws NotFound {
        if(id==null)
            throw new InvalidValue("null id is not valid");
        return authorRepository.deleteAuthor(id);
    }

    @Override
    public Author findById(String id) throws NotFound {
        if(id==null)
            throw new InvalidValue("null id is invalid");
        return authorRepository.findById(id);
    }
}
