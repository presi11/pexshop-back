package co.edu.udea.pexshop.domain.pet.service;

import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.pet.repository.IPetRepository;
import co.edu.udea.pexshop.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPetServiceImpl implements IPetService {

    @Autowired
    private IPetRepository iPetRepository;


    @Override
    public List<Pet> findAll() {
        return iPetRepository.findAll();
    }

    @Override
    public List<Pet> findAllByOwner(User user) {
        return iPetRepository.findAllByOwner(user);
    }

    @Override
    public Pet findById(Long id) {
        return iPetRepository.findById(id).orElse(null);
    }

    @Override
    public Pet findByOwner(User user) {
        return iPetRepository.findByOwner(user);
    }

    @Override
    public Pet create(Pet pet) {
        return iPetRepository.save(pet);
    }

    @Override
    public Pet deleteById(Long id) {
        Pet pet = findById(id);
        if (pet == null) {
            return null;
        }
        iPetRepository.deleteById(id);
        return pet;
    }
}
