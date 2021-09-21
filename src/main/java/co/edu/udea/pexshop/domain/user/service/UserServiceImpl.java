package co.edu.udea.pexshop.domain.user.service;

import co.edu.udea.pexshop.domain.user.model.dto.RegisterUserDTO;
import co.edu.udea.pexshop.domain.user.model.dto.UserResponseDTO;
import co.edu.udea.pexshop.domain.user.model.entity.Role;
import co.edu.udea.pexshop.domain.user.model.entity.User;
import co.edu.udea.pexshop.domain.user.repository.IRoleRepository;
import co.edu.udea.pexshop.domain.user.repository.IUserRepository;
import javassist.tools.web.BadHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    Logger logger = LoggerFactory.getLogger(UserServiceSecure.class);

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IRoleRepository repository;

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> listAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return iUserRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> listByUsername(String username) {
        return iUserRepository.findAllByUsername(username);
    }

    @Override
    public UserResponseDTO findByUsername(String username) {

        return null;
    }


    @Override
    public User findUserByUsername(String username) {
        return iUserRepository.findByUsername(username).get();
    }


    public UserResponseDTO createUserDTO(RegisterUserDTO registerUserDTO) throws Exception {
        List<User> expectedNullUser = listByUsername(registerUserDTO.getUserName());
        if(expectedNullUser.size() != 0 || registerUserDTO.getUserName().equals("") || registerUserDTO.getUserName().equals("")) {
            throw new Exception("User can not be created");
        }
        User newUser = new User();
        newUser.setUsername(registerUserDTO.getUserName());
        newUser.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        newUser.setEmail(registerUserDTO.getUserName());
        newUser.setAuthenticationType("google");
        newUser.setLogInCode(passwordEncoder.encode(registerUserDTO.getPassword()));
        Role ownerRole = repository.getById(1L);
        newUser.setRole(ownerRole);
        iUserRepository.save(newUser);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUsername(registerUserDTO.getUserName());
        return  userResponseDTO;
    }

}
