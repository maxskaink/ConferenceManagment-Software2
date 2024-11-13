package java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.repository;

import org.springframework.stereotype.Repository;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.DuplicateInformation;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Organizer;
import java.co.edu.unicauca.conferencemicroservice.domain.port.out.IOrganizerRepository;
import java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity.OrganizerEntity;
import java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.mapper.OrganizerMapper;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerRepository implements IOrganizerRepository {

    private final List<OrganizerEntity> organizers;

    public OrganizerRepository() {
        this.organizers = new ArrayList<>();
        generateBaseInfo();
    }

    @Override
    public Organizer saveOrganizer(Organizer organizer) throws DuplicateInformation {
        for (OrganizerEntity organizerEntity : organizers) {
            if (organizerEntity.getId().equals(organizer.getId())) {
                throw new DuplicateInformation("Organizer with id " + organizer.getId() + " already exists");
            }
        }
        organizers.add(OrganizerMapper.toOrganizerEntity(organizer));
        return organizer;
    }

    @Override
    public List<Organizer> findAllOrganizers() {
        List<Organizer> listOrganizers = new ArrayList<>();
        for (OrganizerEntity organizerEntity : organizers) {
            if(organizerEntity.isActive())
                listOrganizers.add(OrganizerMapper.toOrganizer(organizerEntity));
        }
        return listOrganizers;
    }

    @Override
    public Organizer findOrganizerById(String id) throws NotFound {
        for (OrganizerEntity organizerEntity : organizers) {
            if (organizerEntity.getId().equals(id)&& organizerEntity.isActive()) {
                return OrganizerMapper.toOrganizer(organizerEntity);
            }
        }
        throw new NotFound("Organizer with id " + id + " not found");
    }

    @Override
    public Organizer deleteOrganizerById(String id) throws NotFound {
        for (OrganizerEntity organizerEntity : organizers) {
            if (organizerEntity.getId().equals(id)) {
                organizerEntity.setActive(false);
                return OrganizerMapper.toOrganizer(organizerEntity);
            }
        }
        throw new NotFound("Organizer with id " + id + " not found");
    }

    private void generateBaseInfo() {
        organizers.add(new OrganizerEntity("5555", "Alguien importante", "john.doe@example.com", true));
    }
}
