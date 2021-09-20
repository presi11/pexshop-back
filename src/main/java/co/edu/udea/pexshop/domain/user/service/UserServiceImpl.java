package co.edu.udea.pexshop.domain.user.service;

import co.edu.udea.pexshop.domain.user.model.dto.UserResponseDTO;
import co.edu.udea.pexshop.domain.user.model.entity.User;
import co.edu.udea.pexshop.domain.user.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    Logger logger = LoggerFactory.getLogger(UserServiceSecure.class);

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

}
