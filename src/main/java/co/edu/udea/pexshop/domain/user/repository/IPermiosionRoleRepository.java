package co.edu.udea.pexshop.domain.user.repository;


import co.edu.udea.pexshop.domain.user.model.entity.PermissionRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPermiosionRoleRepository extends CrudRepository<PermissionRole, Long> {

    @Query("SELECT pr  FROM PermissionRole pr where pr.role.id = ?1")
    public List<PermissionRole> findPermissionsByRole(String roleId);
}
