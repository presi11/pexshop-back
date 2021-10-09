package co.edu.udea.pexshop.domain.schedule.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateScheduleDTO {
    private int petId;
    private int loungeId;
    private boolean sunDay;
    private boolean school;
    private boolean kindergarten;
}
