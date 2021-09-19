package co.edu.udea.pexshop.domain.user.repository;

import co.edu.udea.pexshop.domain.user.model.entity.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPermissionRepository extends CrudRepository<Permission, Long> {

    @Query("SELECT p, pr, rl FROM Permission p JOIN  p.permisionRoleList pr join pr.role rl where  rl.id = ?1")
    List<Permission> findPermissionsByRoleCode(Long roleCode);
}
