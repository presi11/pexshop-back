package co.edu.udea.pexshop.domain.user.service.permisions;


import co.edu.udea.pexshop.domain.user.model.entity.Permission;
import co.edu.udea.pexshop.domain.user.repository.IPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionsServiceImpl implements IPermisionsService{

    @Autowired
    private IPermissionRepository permissionRepository;

    @Override
    public List<Permission> getPermisionsByRole(Long roleId) {
        return permissionRepository.findPermissionsByRoleCode(roleId);
    }
}
