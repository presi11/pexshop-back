package co.edu.udea.pexshop.domain.pet.util.listmapper;

import co.edu.udea.pexshop.domain.pet.model.dto.PetResponseDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;

import java.util.List;

public interface IPetResponseListMapper {

    List<PetResponseDTO> modelToDto(List<Pet> pets);

}
