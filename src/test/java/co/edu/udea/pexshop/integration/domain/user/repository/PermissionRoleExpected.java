package co.edu.udea.pexshop.integration.domain.user.repository;

import co.edu.udea.pexshop.domain.user.model.entity.Permission;
import co.edu.udea.pexshop.domain.user.model.entity.PermissionRole;
import co.edu.udea.pexshop.domain.user.model.entity.Role;
import co.edu.udea.pexshop.domain.user.repository.IPermiosionRoleRepository;
import co.edu.udea.pexshop.domain.user.repository.IPermissionRepository;
import co.edu.udea.pexshop.domain.user.repository.IRoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PermissionRoleExpected {

    @Autowired
    private IPermiosionRoleRepository permiosionRoleRepository;

    @Autowired
    private IPermissionRepository permissionRepository;

    @Autowired
    private IRoleRepository iRoleRepository;

    Long ROLE_CODE_OWNER = 1L;
    Long PERMISSION_CODE_CREATE_PET = 1L;

    @Test
    public void getRoleListRepositoryExpected(){
        // code to create associate role with permission
        Permission permission = permissionRepository.findById(PERMISSION_CODE_CREATE_PET).get();
        Role role = iRoleRepository.findById(ROLE_CODE_OWNER).get();
        PermissionRole permissionRole = new PermissionRole();
        permissionRole.setPermission(permission);
        permissionRole.setRole(role);

        PermissionRole newPermissionRole = permiosionRoleRepository.save(permissionRole);
        System.out.println("holis");
        assertTrue(newPermissionRole instanceof PermissionRole);
        List<Permission> permissionListFromRole = permissionRepository.findPermissionsByRoleCode(ROLE_CODE_OWNER);
        assertTrue(permissionListFromRole.get(0) instanceof Permission);
    }
}
