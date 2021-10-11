package co.edu.udea.pexshop.domain.pet.repository;

import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPetRepository extends JpaRepository<Pet,Long> {

    List<Pet> findAllByOwner(User user);
    List<Pet> findAllByStatus(String status);
    Pet findByOwner(User user);

    @Query("SELECT pet from Pet pet where pet.id=?1 AND pet.owner.id = ?2")
    Pet findPetByUserAndPetId(Long petId, Long userId);
}
