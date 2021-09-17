package co.edu.udea.pexshop.domain.user.service.permisions;

import co.edu.udea.pexshop.domain.user.entity.Permission;

import java.util.List;

public interface IPermisionsService {

    public List<Permission> getPermisionsByRole(Long roleId);
}
