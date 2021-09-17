package co.edu.udea.pexshop.domain.pet.service;

import co.edu.udea.pexshop.domain.pet.model.entity.Race;
import co.edu.udea.pexshop.domain.pet.repository.IRaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceServiceImpl implements IRaceService {

    @Autowired
    private IRaceRepository iRaceRepository;

    @Override
    public Race findById(Long id) {
        return iRaceRepository.findById(id).orElse(null);
    }
}
