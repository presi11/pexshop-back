package co.edu.udea.pexshop.domain.pet.mapper;

import co.edu.udea.pexshop.domain.pet.model.dto.PetResponseDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.user.mapper.IUserRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetResponseMapperImpl implements IPetResponseMapper{

    @Autowired
    private IRaceMapper iRaceMapper;
    @Autowired
    private IUserRequestMapper iUserRequestMapper;

    @Override
    public PetResponseDTO modelToDto(Pet pet) {
        PetResponseDTO petResponseDTO = new PetResponseDTO();
        petResponseDTO.setId(pet.getId());
        petResponseDTO.setRace(iRaceMapper.modelToDto(pet.getRace()));
        petResponseDTO.setOwner(iUserRequestMapper.modelToDto(pet.getOwner()));
        petResponseDTO.setSize(pet.getSize());
        petResponseDTO.setAge(pet.getAge());
        return petResponseDTO;
    }

    @Override
    public Pet dtoToModel(PetResponseDTO petResponseDTO) {
        Pet pet = new Pet();
        pet.setId(petResponseDTO.getId());
        pet.setRace(iRaceMapper.dtoToModel(petResponseDTO.getRace()));
        pet.setOwner(iUserRequestMapper.dtoToModel(petResponseDTO.getOwner()));
        pet.setSize(petResponseDTO.getSize());
        pet.setAge(petResponseDTO.getAge());
        return pet;
    }
}