package co.edu.udea.pexshop.domain.user.service;

import co.edu.udea.pexshop.domain.user.model.dto.UserResponseDTO;
import co.edu.udea.pexshop.domain.user.model.entity.User;
import co.edu.udea.pexshop.domain.user.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserServiceSecure implements IUserService{

    Logger logger = LoggerFactory.getLogger(UserServiceSecure.class);

    @Autowired
    private IUserRepository userRepository;


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
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            return userResponseDTO;
        }catch (UnauthorizedClientException ex) {
            logger.info(String.format("user %s not found", username));
            // throw new UnauthorizedClientException("");
            return null;
        }
    }
}
