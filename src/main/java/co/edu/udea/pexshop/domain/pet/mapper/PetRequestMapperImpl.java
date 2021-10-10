package co.edu.udea.pexshop.domain.pet.mapper;

import co.edu.udea.pexshop.domain.pet.model.dto.PetRequestDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.pet.service.IRaceService;
import co.edu.udea.pexshop.domain.pet.service.RaceServiceImpl;
import co.edu.udea.pexshop.domain.user.model.entity.User;
import co.edu.udea.pexshop.domain.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PetRequestMapperImpl implements IPetRequestMapper {

    @Autowired
    private RaceServiceImpl iRaceService;

    @Override
    public PetRequestDTO modelToDto(Pet pet) {
        PetRequestDTO petRequestDTO = new PetRequestDTO();
        if (pet.getId() != null) {
            petRequestDTO.setId(pet.getId());
        }
        petRequestDTO.setPetName(pet.getPetName());
        petRequestDTO.setRaceId(pet.getRace().getId());
        petRequestDTO.setOwnerId(Optional.ofNullable(pet.getOwner().getId()));
        petRequestDTO.setSize(pet.getSize());
        petRequestDTO.setAge(pet.getAge());
        petRequestDTO.setVaccinationPlan(pet.getVaccinationPlan());
        petRequestDTO.setCareToHave(pet.getCareToHave());

        return petRequestDTO;

    }

    @Override
    public Pet dtoToModel(PetRequestDTO petRequestDTO, Long userId) {
        Pet pet = new Pet();
        if (petRequestDTO.getId() != null){
            pet.setId(petRequestDTO.getId());
        }
        pet.setPetName(petRequestDTO.getPetName());
        System.out.println(petRequestDTO.getId());
        pet.setRace(iRaceService.findById(petRequestDTO.getRaceId()));
        System.out.println(pet.getRace());
        User user = new User();
        user.setId(userId);
        pet.setOwner(user);
        pet.setSize(petRequestDTO.getSize());
        pet.setAge(petRequestDTO.getAge());
        pet.setVaccinationPlan(petRequestDTO.getVaccinationPlan());
        pet.setCareToHave(petRequestDTO.getCareToHave());

        return pet;

    }
}
