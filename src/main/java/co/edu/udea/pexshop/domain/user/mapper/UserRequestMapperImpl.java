package co.edu.udea.pexshop.domain.user.mapper;

import co.edu.udea.pexshop.domain.user.model.dto.UserRequestDTO;
import co.edu.udea.pexshop.domain.user.model.entity.User;
import co.edu.udea.pexshop.domain.user.service.IRoleService;
import co.edu.udea.pexshop.domain.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapperImpl implements IUserRequestMapper {

    @Autowired
    private IRoleService iRoleService;

    @Override
    public UserRequestDTO modelToDto(User user) {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setId(user.getId());
        userRequestDTO.setUsername(user.getUsername());
        userRequestDTO.setEmail(user.getEmail());
        userRequestDTO.setPassword(null);       //PROVISIONAL PROVISIONAL PROVISIONAL PROVISIONAL
        userRequestDTO.setRole(user.getRole().getId());
        return userRequestDTO;
    }

    @Override
    public User dtoToModel(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setId(userRequestDTO.getId());
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(iRoleService.findById(userRequestDTO.getRole()));
        return user;
    }
}
