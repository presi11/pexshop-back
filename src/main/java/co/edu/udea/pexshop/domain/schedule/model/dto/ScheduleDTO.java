package co.edu.udea.pexshop.domain.schedule.model.dto;

import co.edu.udea.pexshop.domain.pet.model.dto.PetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {

    private Long id;

    private Date scheduleDate;

    private Boolean status;

    private Boolean sunDay;

    private Boolean school;

    private Boolean kindergarten;

    private PetDTO pet;


}
