package co.edu.udea.pexshop.domain.pet.repository;

import co.edu.udea.pexshop.domain.pet.model.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRaceRepository extends JpaRepository<Race, Long> {
}
