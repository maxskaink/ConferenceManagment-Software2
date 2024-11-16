package co.edu.unicauca.conferencemicroservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String email;
    public UserDTO(){}
}
