package co.edu.udea.pexshop.domain.schedule.mapper;

import co.edu.udea.pexshop.domain.pet.model.dto.PetDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.schedule.model.dto.ScheduleDTO;
import co.edu.udea.pexshop.domain.schedule.model.entity.ScheduleEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-11T21:19:53-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class IScheduleMapperImpl implements IScheduleMapper {

    @Override
    public ScheduleDTO toScheduleDTO(ScheduleEntity scheduleEntity) {
        if ( scheduleEntity == null ) {
            return null;
        }

        ScheduleDTO scheduleDTO = new ScheduleDTO();

        scheduleDTO.setId( scheduleEntity.getId() );
        scheduleDTO.setScheduleDate( scheduleEntity.getScheduleDate() );
        scheduleDTO.setStatus( scheduleEntity.getStatus() );
        scheduleDTO.setSunDay( scheduleEntity.getSunDay() );
        scheduleDTO.setSchool( scheduleEntity.getSchool() );
        scheduleDTO.setKindergarten( scheduleEntity.getKindergarten() );
        scheduleDTO.setPet( petToPetDTO( scheduleEntity.getPet() ) );

        return scheduleDTO;
    }

    protected PetDTO petToPetDTO(Pet pet) {
        if ( pet == null ) {
            return null;
        }

        PetDTO petDTO = new PetDTO();

        petDTO.setId( pet.getId() );
        petDTO.setPetName( pet.getPetName() );
        petDTO.setSize( pet.getSize() );
        petDTO.setAge( pet.getAge() );
        petDTO.setVaccinationPlan( pet.getVaccinationPlan() );
        petDTO.setCareToHave( pet.getCareToHave() );

        return petDTO;
    }
}
