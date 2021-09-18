package co.edu.udea.pexshop.domain.user.repository;

import co.edu.udea.pexshop.domain.user.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
