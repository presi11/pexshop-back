package co.edu.udea.pexshop.domain.user.repository;

import co.edu.udea.pexshop.domain.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUsername(String username);
    User findByUsername(String username);

}
