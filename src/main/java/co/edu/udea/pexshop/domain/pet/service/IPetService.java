package co.edu.udea.pexshop.domain.pet.service;

import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.user.model.entity.User;

import java.util.List;

public interface IPetService {

    List<Pet> findAll();
    List<Pet> findAllByOwner(User user);
    Pet findById(Long id);
    Pet findByOwner(User user);
    Pet create(Pet pet);
    Pet deleteById(Long id);

}
