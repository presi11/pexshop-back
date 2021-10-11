package co.edu.udea.pexshop.domain.pet.service;

import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.pet.repository.IPetRepository;
import co.edu.udea.pexshop.domain.user.model.entity.User;
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
        pet.setStatus("PENDING");
        Pet petDB = iPetRepository.save(pet);
        return petDB;
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

    @Override
    public Pet updatePet(Pet pet, Long userId) {
        Pet petDB = iPetRepository.findPetByUserAndPetId(pet.getId(), userId);
        if (petDB == null) {
            return null;
        }
        petDB.setPetName(pet.getPetName());
        petDB.setRace(pet.getRace());
        petDB.setOwner(pet.getOwner());
        petDB.setSize(pet.getSize());
        petDB.setAge(pet.getAge());
        petDB.setVaccinationPlan(pet.getVaccinationPlan());
        petDB.setCareToHave(pet.getCareToHave());

        return iPetRepository.save(petDB);

    }

    @Override
    public Pet acceptPet(Long id) {
        Pet pet = findById(id);
        if (pet == null){
            return null;
        }
        pet.setStatus("ACCEPTED");
        return iPetRepository.save(pet);
    }

    @Override
    public List<Pet> findAllPendingPets(String status) {
        return iPetRepository.findAllByStatus(status);

    }

    @Override
    public Pet getPetByUserIdAndPetId(Long petId, Long userId) {
        return iPetRepository.findPetByUserAndPetId(petId,userId);
    }
}
