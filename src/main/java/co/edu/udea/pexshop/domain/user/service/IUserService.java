package co.edu.udea.pexshop.domain.user.service;

import co.edu.udea.pexshop.domain.user.model.dto.UserResponseDTO;
import co.edu.udea.pexshop.domain.user.model.entity.User;

import java.util.List;


public interface IUserService {

    List<User> listAll();
    User findById(Long id);
    List<User> listByUsername(String username);
    UserResponseDTO findByUsername(String username);

}
