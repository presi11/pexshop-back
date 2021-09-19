package co.edu.udea.pexshop.domain.user.service;

import co.edu.udea.pexshop.domain.user.model.dto.UserResponseDTO;
import co.edu.udea.pexshop.domain.user.model.entity.Permission;
import co.edu.udea.pexshop.domain.user.model.entity.User;
import co.edu.udea.pexshop.domain.user.repository.IUserRepository;
import co.edu.udea.pexshop.domain.user.service.permisions.PermissionsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceSecure implements IUserService, UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserServiceSecure.class);

    final static boolean ACTIVE_USER_CODE = true;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PermissionsServiceImpl permissionsService;

    @Override
    public List<User> listAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> listByUsername(String username) {
        return null;
    }

    @Override
    @Transactional
    public UserResponseDTO findByUsername(String username){
        try {
            User user = userRepository.findByUsername(username).get();
            if(user == null ){
                logger.error(String.format("user $s not found", username));
                throw new UsernameNotFoundException("Login Error: user or password invalid");
            }
            logger.info(String.format("User found: %s", user.getEmail()));
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.setUsername(user.getUsername());
            userResponseDTO.setAcive(ACTIVE_USER_CODE);
            Long userRoleCode = user.getRole().getId();
            List<Permission> permissions = permissionsService.getPermisionsByRole(userRoleCode);
            userResponseDTO.setPermissions(permissions);
            return userResponseDTO;
        }catch (UnauthorizedClientException ex) {
            logger.info(String.format("user %s not found", username));
            throw new UnauthorizedClientException("");
        }
    }

    public List<GrantedAuthority> returnTokenToClient(UserResponseDTO userDto) {
        List<GrantedAuthority> authorities = userDto.getPermissions().stream().map(permission -> new SimpleGrantedAuthority(
                permission.getId().toString() + " - " +permission.getDescription()
        )).peek(authority -> logger.info("Permission: " + authority.getAuthority())).collect(Collectors.toList());

        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResponseDTO userInsession = findByUsername(username);

        if(userInsession == null) {
            logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema!");
        }

        List<GrantedAuthority> authorities = returnTokenToClient(userInsession);

        return new org.springframework.security.core.userdetails.User(userInsession.getUsername(), "", authorities);
    }
}
