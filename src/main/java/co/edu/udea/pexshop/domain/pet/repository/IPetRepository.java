package co.edu.udea.pexshop.domain.pet.repository;

import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPetRepository extends JpaRepository<Pet,Long> {

    List<Pet> findAllByOwner(User user);
    Pet findByOwner(User user);

}
