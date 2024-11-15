package java.co.edu.unicauca.conferencemicroservice.application.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.co.edu.unicauca.conferencemicroservice.application.dto.UserDTO;
import java.co.edu.unicauca.conferencemicroservice.application.mapper.MapperUserDTO;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Organizer;
import java.co.edu.unicauca.conferencemicroservice.application.port.in.IOrganizerService;
import java.co.edu.unicauca.conferencemicroservice.application.port.out.IOrganizerRepository;
import java.util.List;

@Service
public class OrganizerService implements IOrganizerService {

    private final IOrganizerRepository repositoryOrganizer;

    @Autowired
    public OrganizerService(IOrganizerRepository repository){
        repositoryOrganizer = repository;
    }

    @Override
    public Organizer saveOrganizer(UserDTO organizerToSave) {

        if(organizerToSave == null)
            throw new InvalidValue("null organizer to save is invalid");

        return repositoryOrganizer.saveOrganizer(MapperUserDTO.toOrganizer(organizerToSave ));
    }

    @Override
    public List<Organizer> findAllOrganizers() throws NotFound {
        return this.repositoryOrganizer.findAllOrganizers();
    }

    @Override
    public Organizer findOrganizerById(String id) throws NotFound {
        if(id == null)
            throw new InvalidValue("null id is invalid");
        return this.repositoryOrganizer.findOrganizerById(id);
    }

    @Override
    public Organizer deleteOrganizerById(String id) throws NotFound {
        if(null == id)
            throw new InvalidValue("null id is invalid");

        return repositoryOrganizer.deleteOrganizerById(id);
    }
}
