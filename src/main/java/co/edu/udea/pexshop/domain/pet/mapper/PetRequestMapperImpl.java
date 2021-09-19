package co.edu.udea.pexshop.domain.pet.mapper;

import co.edu.udea.pexshop.domain.pet.model.dto.PetRequestDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.pet.service.IRaceService;
import co.edu.udea.pexshop.domain.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetRequestMapperImpl implements IPetRequestMapper {

    @Autowired
    private IRaceService iRaceService;
    @Autowired
    private IUserService iUserService;

    @Override
    public PetRequestDTO modelToDto(Pet pet) {
        PetRequestDTO petRequestDTO = new PetRequestDTO();
        petRequestDTO.setId(pet.getId());
        petRequestDTO.setPetName(pet.getPetName());
        petRequestDTO.setRaceId(pet.getRace().getId());
        petRequestDTO.setOwnerId(pet.getOwner().getId());
        petRequestDTO.setSize(pet.getSize());
        petRequestDTO.setAge(pet.getAge());

        return petRequestDTO;

    }

    @Override
    public Pet dtoToModel(PetRequestDTO petRequestDTO) {
        Pet pet = new Pet();
        pet.setId(petRequestDTO.getId());
        pet.setPetName(petRequestDTO.getPetName());
        pet.setRace(iRaceService.findById(petRequestDTO.getRaceId()));
        pet.setOwner(iUserService.findById(petRequestDTO.getOwnerId()));
        pet.setSize(petRequestDTO.getSize());
        pet.setAge(petRequestDTO.getAge());

        return pet;

    }
}
