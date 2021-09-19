package co.edu.udea.pexshop.domain.pet.mapper;

import co.edu.udea.pexshop.domain.pet.model.dto.PetRequestDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.pet.service.IRaceService;
import co.edu.udea.pexshop.domain.pet.service.RaceServiceImpl;
import co.edu.udea.pexshop.domain.user.service.IUserService;
import co.edu.udea.pexshop.domain.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetRequestMapperImpl implements IPetRequestMapper {

    @Autowired
    private RaceServiceImpl iRaceService;
    @Autowired
    private UserServiceImpl iUserService;

    @Override
    public PetRequestDTO modelToDto(Pet pet) {
        PetRequestDTO petRequestDTO = new PetRequestDTO();
        petRequestDTO.setId(pet.getId());
        petRequestDTO.setPetName(pet.getPetName());
        petRequestDTO.setRaceId(pet.getRace().getId());
        petRequestDTO.setOwnerId(pet.getOwner().getId());
        petRequestDTO.setSize(pet.getSize());
        petRequestDTO.setAge(pet.getAge());
        petRequestDTO.setVaccinationPlan(pet.getVaccinationPlan());
        petRequestDTO.setCareToHave(pet.getCareToHave());

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
        pet.setVaccinationPlan(petRequestDTO.getVaccinationPlan());
        pet.setCareToHave(petRequestDTO.getCareToHave());

        return pet;

    }
}
