package java.co.edu.unicauca.conferencemicroservice.application.mapper;

import java.co.edu.unicauca.conferencemicroservice.application.dto.UserDTO;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Author;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Organizer;

public class MapperUserDTO {
    /**
     * Map an instance of UserDTO to Author
     * @param userDTO info of the user
     * @return instance of Author
     */
    public static Author toAuthor(UserDTO userDTO){
        return new Author(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail()
        );
    }

    /**
     * Map an instance of UserDTo to Organizer
     * @param userDTO info user to map
     * @return instance of Organizer
     */
    public static Organizer toOrganizer(UserDTO userDTO){
        return new Organizer(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail()
        );
    }
}
