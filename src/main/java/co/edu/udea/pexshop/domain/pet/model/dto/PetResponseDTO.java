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
    private RaceDTO race;
    private UserRequestDTO owner;
    private Double size;
    private int age;

}
