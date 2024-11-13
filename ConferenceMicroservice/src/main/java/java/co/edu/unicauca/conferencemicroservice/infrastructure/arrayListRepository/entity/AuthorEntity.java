package java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AuthorEntity {
    private String id;
    private String name;
    private String email;
    private boolean isActive;
}
