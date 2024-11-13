package java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.mapper;

import java.co.edu.unicauca.conferencemicroservice.domain.model.valueObjects.BasicDate;
import java.co.edu.unicauca.conferencemicroservice.infrastructure.arrayListRepository.entity.BasicDateEntity;

public class BasicDateMapper {
    /**
     * Create an instance of BasicDateEntity based on BasicDate
     * @param basicDate base info
     * @return instance of BasicDateEntity
     */
    public static BasicDateEntity toBasicDateEntity(BasicDate basicDate) {
        return new BasicDateEntity(
                basicDate.getDay(),
                basicDate.getMonth(),
                basicDate.getYear()
        );
    }

    /**
     * Create an instance of BasicDate
     * @param basicDateEntity date to transform
     * @return Instance of BasicDate
     */
    public static BasicDate toBasicDate(BasicDateEntity basicDateEntity) {
        return new BasicDate(
                basicDateEntity.getDay(),
                basicDateEntity.getMonth(),
                basicDateEntity.getYear());
    }
}
