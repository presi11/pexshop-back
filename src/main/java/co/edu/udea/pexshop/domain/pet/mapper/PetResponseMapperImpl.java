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
    public PetResponseDTO petModelToDto(Pet pet) {
        PetResponseDTO petResponseDTO = new PetResponseDTO();
        Long id = pet.getId();
        if (id != null){
            petResponseDTO.setId(id);
        }
        petResponseDTO.setPetName(pet.getPetName());
        if (pet.getRace().getId() != null){
            petResponseDTO.setRace(iRaceMapper.modelToDto(pet.getRace()));
        }

        petResponseDTO.setSize(pet.getSize());
        petResponseDTO.setAge(pet.getAge());
        petResponseDTO.setVaccinationPlan(pet.getVaccinationPlan());
        petResponseDTO.setCareToHave(pet.getCareToHave());
        petResponseDTO.setStatus(pet.getStatus());
        return petResponseDTO;
    }

    @Override
    public Pet dtoToModel(PetResponseDTO petResponseDTO) {
        Pet pet = new Pet();
        if (petResponseDTO.getId() != null){
            pet.setId(petResponseDTO.getId());
        }
        pet.setPetName(petResponseDTO.getPetName());
        if (petResponseDTO.getRace().getId() != null) {
            pet.setRace(iRaceMapper.dtoToModel(petResponseDTO.getRace()));
        }
        if (petResponseDTO.getOwner().getId() != null){
            pet.setOwner(iUserRequestMapper.dtoToModel(petResponseDTO.getOwner()));
        }
        pet.setSize(petResponseDTO.getSize());
        pet.setAge(petResponseDTO.getAge());
        pet.setVaccinationPlan(petResponseDTO.getVaccinationPlan());
        pet.setVaccinationPlan(petResponseDTO.getVaccinationPlan());
        pet.setStatus(petResponseDTO.getStatus());
        return pet;
    }
}
