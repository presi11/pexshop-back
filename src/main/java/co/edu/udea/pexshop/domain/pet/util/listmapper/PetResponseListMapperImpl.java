package co.edu.udea.pexshop.domain.pet.util.listmapper;

import co.edu.udea.pexshop.domain.pet.mapper.IPetResponseMapper;
import co.edu.udea.pexshop.domain.pet.model.dto.PetResponseDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetResponseListMapperImpl implements IPetResponseListMapper {

    @Autowired
    private IPetResponseMapper iPetResponseMapper;

    //Convert List
    @Override
    public List<PetResponseDTO> modelToDto(List<Pet> pets) {
        List<PetResponseDTO> petsResponseDTO = new ArrayList<>();
        for (Pet p : pets
        ) {
            petsResponseDTO.add(iPetResponseMapper.modelToDto(p));
        }
        return petsResponseDTO;
    }
}
