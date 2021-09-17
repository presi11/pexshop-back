package co.edu.udea.pexshop.domain.pet.mapper;

import co.edu.udea.pexshop.domain.pet.model.dto.PetRequestDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;

public interface IPetRequestMapper {

    PetRequestDTO modelToDto(Pet pet);
    Pet dtoToModel(PetRequestDTO petRequestDTO);

}
