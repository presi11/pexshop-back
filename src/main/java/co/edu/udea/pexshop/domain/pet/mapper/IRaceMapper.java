package co.edu.udea.pexshop.domain.pet.mapper;

import co.edu.udea.pexshop.domain.pet.model.dto.PetResponseDTO;
import co.edu.udea.pexshop.domain.pet.model.dto.RaceDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.pet.model.entity.Race;

public interface IRaceMapper {

    RaceDTO modelToDto(Race race);
    Race dtoToModel(RaceDTO raceDTO);

}
