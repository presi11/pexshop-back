package co.edu.udea.pexshop.domain.pet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor

public class PetRequestDTO {

    private Long id;
    private String petName;
    private Long raceId;
    private Long ownerId;
    private String size;
    private int age;
    private String vaccinationPlan;
    private int careToHave;


}
