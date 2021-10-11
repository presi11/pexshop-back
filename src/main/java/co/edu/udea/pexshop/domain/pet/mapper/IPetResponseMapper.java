package co.edu.udea.pexshop.domain.pet.mapper;

import co.edu.udea.pexshop.domain.pet.model.dto.PetRequestDTO;
import co.edu.udea.pexshop.domain.pet.model.dto.PetResponseDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;

public interface IPetResponseMapper {

    PetResponseDTO petModelToDto(Pet pet);
    Pet dtoToModel(PetResponseDTO petResponseDTO);

}
