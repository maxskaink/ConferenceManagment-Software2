package co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class BasicDateEntity {
    private int day;
    private int month;
    private int year;
}
