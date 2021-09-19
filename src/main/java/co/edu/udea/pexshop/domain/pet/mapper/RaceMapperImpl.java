package co.edu.udea.pexshop.domain.pet.mapper;

import co.edu.udea.pexshop.domain.pet.model.dto.RaceDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Race;
import org.springframework.stereotype.Component;

@Component
public class RaceMapperImpl implements IRaceMapper{
    @Override
    public RaceDTO modelToDto(Race race) {
        RaceDTO raceDTO = new RaceDTO();
        raceDTO.setId(race.getId());
        raceDTO.setDescription(race.getDescription());
        return raceDTO;
    }

    @Override
    public Race dtoToModel(RaceDTO raceDTO) {
        Race race = new Race();
        race.setId(raceDTO.getId());
        race.setDescription(raceDTO.getDescription());
        return race;
    }
}
