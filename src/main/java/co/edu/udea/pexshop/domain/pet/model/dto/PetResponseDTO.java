package co.edu.udea.pexshop.domain.pet.model.dto;

import co.edu.udea.pexshop.domain.user.model.dto.UserRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PetResponseDTO {

    private Long id;
    private String petName;
    private RaceDTO race;
    private UserRequestDTO owner;
    private String size;
    private int age;
    private String vaccinationPlan;
    private int careToHave;


}
