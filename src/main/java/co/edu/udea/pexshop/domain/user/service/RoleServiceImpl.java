package co.edu.udea.pexshop.domain.user.service;

import co.edu.udea.pexshop.domain.user.model.entity.Role;
import co.edu.udea.pexshop.domain.user.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Role findById(Long id) {
        return iRoleRepository.findById(id).orElse(null);
    }
}
